/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;

import static BookStore.Services.DataBase.logger;
import BookStore.exceptions.CartNotFoundException;
import BookStore.exceptions.OrderNotFoundException;
import BookStore.models.Book;
import BookStore.models.Cart;
import BookStore.models.CartItem;

import BookStore.models.Order;
import BookStore.models.OrderItem;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author isuru
 */
public class OrderService {

    private final BookService bookService;
    private final CustemerService customerService;
    private final CartService cartService;

    public OrderService() {
        this.bookService = new BookService();
        this.customerService = new CustemerService();
        this.cartService = new CartService();
    }

    public Order createOrder(int customerId) {

        Cart cart = cartService.getCart(customerId);
        if (cart.getItems().isEmpty()) {
            throw new CartNotFoundException("Cannot create order: Cart is empty");
        }

        Order order = new Order(DataBase.getNextOrderId(), customerId);

        DataBase.orders.add(order);

       
        // Convert cart items to order items
        for (CartItem cartItem : cart.getItems()) {
            Book book = bookService.getBooksById(cartItem.getBookId());

            // Check stock availability
            if (book.getStock() < cartItem.getQuantity()) {
                throw new RuntimeException("Not enough stock for book: " + book.getTitle());
            }

            // Create order item
            OrderItem orderItem = new OrderItem(
                    book.getId(),
                    book.getTitle(),
                    book.getPrice(),
                    cartItem.getQuantity()
            );

            // Add to order
            order.addItem(orderItem);
            logger.info("order created");

            // Update book stock
            book.setStock(book.getStock() - cartItem.getQuantity());
        }

        // Clear the cart
        cartService.clearCart(customerId);

        // Save order to database
        (DataBase.orders).add(order);

        return order;
    }

    public List<Order> getCustomerOrders(int customerId) {
        // Verify customer exists
        customerService.getCustomerById(customerId);

        // Get orders for customer
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : DataBase.orders) {
            if (order.getCustomerId() == customerId) {
                customerOrders.add(order);
                logger.info("get all orders"); 
            }
        }

        return customerOrders;
    }

    public Order getOrderById(int customerId, int orderId) {
        // Verify customer exists
        customerService.getCustomerById(customerId);

        // Find order
        for (Order order : DataBase.orders) {
            if (order.getId() == orderId && order.getCustomerId() == customerId) {
                 logger.info("get  orders by id"); 
                return order;
            }
        }

        throw new OrderNotFoundException("Order not found with ID: " + orderId);
    }
}

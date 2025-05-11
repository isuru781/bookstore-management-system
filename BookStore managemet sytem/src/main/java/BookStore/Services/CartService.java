/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;

/**
 *
 * @author isuru
 */


import static BookStore.Services.DataBase.logger;
import BookStore.exceptions.OutOfStockException;
import BookStore.models.Book;
import BookStore.models.Cart;
import BookStore.models.CartItem;

public class CartService {
    
    private final BookService bookService;
    
    public CartService() {
        this.bookService = new BookService();
    }
    
    public Cart getCart(int customerId) {

      
        for (Cart cart : DataBase.carts) {
            if (cart.getCustomerId() == customerId) {
                logger.info("cart return");
                return cart;
            } else {

            }
        }

        // Create new cart if not found
        Cart newCart = new Cart(customerId);
        logger.info("cart created");
        DataBase.carts.add(newCart);
        return newCart;
    }
    
    public void addItemToCart(int customerId, CartItem cartItem) {
        // Verify book exists and has enough stock
        Book book = bookService.getBooksById(cartItem.getBookId());
        
        if (book.getStock() < cartItem.getQuantity()) {
            throw new OutOfStockException("Not enough stock for book with ID: " + cartItem.getBookId());
        }
        
        // Get or create cart
        Cart cart = getCart(customerId);
        
        // Add item to cart
        cart.addItem(cartItem);
        logger.info("cart added item");
        book.setStock(book.getStock()-cartItem.getQuantity());
        
    }
    
    public void updateCartItem(int customerId, int bookId, int quantity) {
        // Verify book exists and has enough stock
        Book book = bookService.getBooksById(bookId);
        
        if (book.getStock() < quantity) {
            throw new OutOfStockException("Not enough stock for book with ID: " + bookId);
        }
        
        // Get cart
        Cart cart = getCart(customerId);
        logger.info("cart updated item");
        
        // Update item quantity
        cart.updateItemQuantity(bookId, quantity);
    }
    
    public void removeCartItem(int customerId, int bookId) {
        // Get cart
        Cart cart = getCart(customerId);
        logger.info("cart removed item");
        // Remove item
        cart.removeItem(bookId);
    }
    
    public void clearCart(int customerId) {
        // Get cart
        Cart cart = getCart(customerId);
        
        // Clear items
        cart.getItems().clear();
        logger.info("cart cleard item");
    }
}
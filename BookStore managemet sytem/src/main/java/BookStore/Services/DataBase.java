/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;

import BookStore.models.Author;
import BookStore.models.Book;
import BookStore.models.Cart;
import BookStore.models.Customer;
import BookStore.models.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author isuru
 */
public class DataBase {
public static final Logger logger = Logger.getLogger(DataBase.class.getName());
    public static final List<Author> authers = new ArrayList<>();
    public static final List<Book> books = new ArrayList<>();
    public static final List<Customer> customer = new ArrayList<>();
    public static final List<Cart> carts = new ArrayList<>();

    public static  List<Order> orders = new ArrayList<>();
    private static int orderIdCounter = 1;

    public static int getNextOrderId() {
        return orderIdCounter++;
    }

}

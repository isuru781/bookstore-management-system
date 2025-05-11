/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.models;

/**
 *
 * @author isuru
 */


public class OrderItem {
    private int bookId;
    private String bookTitle;
    private double price;
    private int quantity;
    
    public OrderItem() {
    }
    
    public OrderItem(int bookId, String bookTitle, double price, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getSubtotal() {
        return price * quantity;
    }
}
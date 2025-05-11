/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isuru
 */


public class Cart {
    private int customerId;
    private List<CartItem> items;
    
    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public Cart(int customerId) {
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    
    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    
    public void addItem(CartItem item) {
        // Check if the item already exists
        for (CartItem existingItem : items) {
            if (existingItem.getBookId() == item.getBookId()) {
                // Update quantity instead of adding a new item
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        // Add new item if it doesn't exist
        items.add(item);
    }
    
    public void updateItemQuantity(int bookId, int quantity) {
        for (CartItem item : items) {
            if (item.getBookId() == bookId) {
                item.setQuantity(quantity);
                return;
            }
        }
    }
    
    public void removeItem(int bookId) {
        for (CartItem item : items) {
            if (item.getBookId() == bookId) {
                items.remove(item);
                return ;
            }
        }
        
    }
}
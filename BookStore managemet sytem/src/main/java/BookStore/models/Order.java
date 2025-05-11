/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author isuru
 */
public class Order {
    private int id;
    private int customerId;
    private Date orderDate;
    private List<OrderItem> items;
    private double totalAmount;
    private String status; // "PLACED", "PROCESSING", "SHIPPED", "DELIVERED"
    
    public Order() {
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.status = "PLACED";
    }
    
    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.status = "PLACED";
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItem> items) {
        this.items = items;
        calculateTotalAmount();
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotalAmount();
    }
    
    private void calculateTotalAmount() {
        totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.getSubtotal();
        }
    }  
}

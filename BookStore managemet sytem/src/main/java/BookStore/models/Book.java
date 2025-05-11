/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.models;

/**
 *
 * @author isuru
 */
public class Book {
    private int id;
    private int authorId;
    private int isbn;
    private int publicationYear;
    private int price;
    private int stock;

    private String title;

    public Book(int authorId, int isbn, int publicationYear, int price, int stock, int id, String title) {
        this.authorId = authorId;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stock = stock;
        this.id = id;
        this.title = title;
    }

    public Book() {
    }
    
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    

    @Override
    public String toString() {
        return "Book{" + "authorId=" + authorId + ", isbn=" + isbn + ", publicationYear=" + publicationYear + ", price=" + price + ", stock=" + stock + ", id=" + id + ", title=" + title + '}';
    }

}

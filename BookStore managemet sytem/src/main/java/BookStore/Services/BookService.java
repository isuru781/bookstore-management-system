/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;


import static BookStore.Services.DataBase.logger;

import BookStore.exceptions.BookNotFoundException;

import BookStore.models.Book;
import java.util.List;

/**
 *
 * @author isuru
 */
public class BookService {

    public Book addBooks(Book books) {
        DataBase.books.add(books);
        logger.info("Book added sucessfully");
        return books;
    }

    public List<Book> getBooks() {
       logger.info("get all books");
        return DataBase.books;
    }

    public Book getBooksById(int id) {
        for (Book book : DataBase.books) {
            if (book.getId() == id) {
                logger.info("get books by id");
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with ID: " + id);
    }

    public Book EditBooks(int id, Book books) {
        for (Book book : DataBase.books) {
            if (book.getId() == id) {
                book.setAuthorId(id);
                book.setIsbn(books.getIsbn());
                book.setPublicationYear(books.getPublicationYear());
                book.setPrice(books.getPrice());
                book.setStock(books.getStock());
                book.setTitle(books.getTitle());
                logger.info("Books update sucessfully");
                return books;
            }

        }
        throw new BookNotFoundException("Books not found with ID: " + id);

    }

    public String deleteBooks(int id) {
        System.out.println("del id");
        for (Book book : DataBase.books) {
            if (book.getId() == id) {
                DataBase.books.remove(book);
                logger.info("books delete sucessfully");
                return "books delete sucessfully";
            }

        }
        throw new BookNotFoundException("Books not found with ID: " + id);

    }
    
    
    

   

   

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;

import static BookStore.Services.DataBase.logger;
import BookStore.exceptions.AuthorNotFoundException;
import BookStore.exceptions.BookNotFoundException;
import BookStore.models.Author;
import BookStore.models.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author isuru
 */
public class AutherServices {

    public Author addAuthers(Author auther) {
        DataBase.authers.add(auther);
        logger.info("Auther added sucessfully");
        System.out.println("Auther added sucessfully");
        return auther;
    }

    public List<Author> getAuthers() {
        logger.info("Authers getting sucessfully");
        return DataBase.authers;
    }

    public Author getAuthorById(int id) {
        for (Author auth : DataBase.authers) {
            if (auth.getId() == id) {
                logger.log(Level.INFO, "Authers getting sucessfully id{0}", id);
                return auth;
            }
        }
        throw new AuthorNotFoundException("Author not found with ID: " + id);
    }

    public Author EditAuthor(int id, Author auther) {
        for (Author auth : DataBase.authers) {
            if (auth.getId() == id) {
                auth.setFirstName(auther.getFirstName());
                auth.setLastName(auther.getLastName());
                auth.setBiography(auther.getBiography());
                logger.info("Auther update sucessfully");
                return auther;
            }

        }
        throw new AuthorNotFoundException("Author not found with ID: " + id);

    }

    public String deleteAuthor(int id) {
        for (Author auth : DataBase.authers) {
            if (auth.getId() == id) {
                DataBase.authers.remove(auth);
                logger.info("Auther delete sucessfully");
                return "Auther delete sucessfully";
            }

        }
        throw new AuthorNotFoundException("Author not found with ID: " + id);

    }
    
    public List<Book> getAuthorBooks(int id) {
        System.out.println("id" + id);
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : DataBase.books) {
            if (book.getAuthorId() == id) {
                booksByAuthor.add(book);
            }
        }
        if (booksByAuthor.isEmpty()) {
            throw new BookNotFoundException("No books found for Author with ID: " + id);
        }
        logger.info("books find Auther id ");
        return booksByAuthor;
    }
    
}

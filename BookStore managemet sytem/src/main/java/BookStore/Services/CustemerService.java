/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.Services;


import static BookStore.Services.DataBase.logger;
import BookStore.exceptions.CustomerNotFoundException;

import BookStore.models.Customer;
import java.util.List;

/**
 *
 * @author isuru
 */
public class CustemerService {

    public Customer addCustomer(Customer customer) {
        DataBase.customer.add(customer);
        logger.info("Customer added sucessfully");
        return customer;
    }

    public List<Customer> getCustomer() {
       logger.info("get all custemers");
        return DataBase.customer;
    }

    public Customer getCustomerById(int id) {
        for (Customer cust : DataBase.customer) {
            if (cust.getId() == id) {
                logger.info("get custemer by id ");
                return cust;
            }
        }
        throw new CustomerNotFoundException("Customer not found with ID: " + id);
    }

    public Customer EditCustomer(int id, Customer customer) {
        for (Customer cust : DataBase.customer) {
            if (cust.getId() == id) {

                cust.setFirstName(customer.getFirstName());
                cust.setLastName(customer.getLastName());
                cust.setEmail(customer.getEmail());
                cust.setPassword(customer.getPassword());
                logger.info("Custemer update sucessfully");

                return customer;
            }

        }
        throw new CustomerNotFoundException("Customer not found with ID: " + id);

    }

    public String deleteAuthor(int id) {
         for (Customer cust : DataBase.customer) {
            if (cust.getId() == id) {

                DataBase.customer.remove(cust);
                logger.info("Custemer delete sucessfully");
                return "Custemer delete sucessfully";
            }

        }
        throw new CustomerNotFoundException("Customer not found with ID: " + id);


    }

  

   

}

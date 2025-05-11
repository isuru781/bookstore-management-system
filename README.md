
# Bookstore Management System API(JAX-RS)

## Overview
This project is a Bookstore Management System created using RESTful web services with the Java API for RESTful Web Services (JAX-RS). The API manages various entities such as books, authors, customers, shopping carts, and orders.

## Table of Contents
- [Introduction](#introduction)
- [Project Overview](#project-overview)
- [Getting Started](#getting-started)
- [Implementation Details](#implementation-details)
  - [Model Class Implementation](#model-class-implementation)
  - [Service Class Implementation](#service-class-implementation)
  - [Logging](#logging)
  - [Exception Handling](#exception-handling)
  - [Resource Class Implementation](#resource-class-implementation)
- [Conclusion](#conclusion)


## Introduction
The Bookstore Management System API provides a complete approach to managing operations and data related to a bookstore. It includes functionalities for managing books, authors, customers, carts, and orders.

## Project Overview
The API is designed to handle various operations related to bookstore management, utilizing an ArrayList to store data.

## Getting Started
To start a JAX-RS project, follow these steps:

1. **Set Up Your Development Environment**:
   - Install Java Development Kit (JDK) version 8 or higher.
   - Install an Integrated Development Environment (IDE) such as Eclipse, IntelliJ IDEA, or NetBeans.

2. **Create a New Maven Project**:
   - Open your IDE and create a new Maven project.
   - Add the following dependencies to your `pom.xml` file:
     ```xml
     <dependencies>
         <dependency>
             <groupId>javax.ws.rs</groupId>
             <artifactId>javax.ws.rs-api</artifactId>
             <version>2.1</version>
         </dependency>
         <dependency>
             <groupId>org.glassfish.jersey.containers</groupId>
             <artifactId>jersey-container-servlet-core</artifactId>
             <version>2.35</version>
         </dependency>
         <dependency>
             <groupId>org.glassfish.jersey.media</groupId>
             <artifactId>jersey-media-json-jackson</artifactId>
             <version>2.35</version>
         </dependency>
     </dependencies>
     ```

3. **Configure Your Web Application**:
   - Create a `web.xml` file in the `src/main/webapp/WEB-INF` directory to configure the JAX-RS application:
     ```xml
     <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" 
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
              http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
              version="3.1">
         <servlet>
             <servlet-name>Jersey REST Service</servlet-name>
             <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
             <init-param>
                 <param-name>jersey.config.server.provider.packages</param-name>
                 <param-value>your.package.name</param-value>
             </init-param>
             <load-on-startup>1</load-on-startup>
         </servlet>
         <servlet-mapping>
             <servlet-name>Jersey REST Service</servlet-name>
             <url-pattern>/api/*</url-pattern>
         </servlet-mapping>
     </web-app>
     ```

4. **Create Your JAX-RS Resources**:
   - Create resource classes in your specified package (e.g., `your.package.name`) to handle HTTP requests.

5. **Run Your Application**:
   - Use a server like Apache Tomcat or Jetty to deploy your application.
   - Access your API at `http://localhost:8080/your-app-name/api/`.

## Implementation Details

### Model Class Implementation
- **Author**: Represents an author with attributes like id, first name, last name, and biography.
- **Book**: Represents a book with attributes such as id, authorId, ISBN, publication year, price, and stock.
- **Cart**: Represents a shopping cart associated with a customer.
- **Cart Items**: Represents items in the cart with attributes for bookId and quantity.
- **Customer**: Represents a customer with attributes like id, first name, last name, email, and password.
- **Order**: Represents a customer order with attributes for id, customerId, order date, items, and amount.
- **Order Items**: Represents items in an order with attributes for bookId, book title, price, and quantity.

### Service Class Implementation
- **AuthorService**: Handles CRUD operations for authors.
- **BookService**: Handles CRUD operations for books.
- **CustomerService**: Manages customer data.
- **CartService**: Manages shopping cart operations.
- **OrderService**: Manages order creation and retrieval.

### Logging
The project uses `java.util.logging` to record all system activities, including CRUD operations and warnings.

### Exception Handling
Custom exceptions and mappers are implemented to provide meaningful error messages and HTTP responses.

### Resource Class Implementation
- **Book Resource**: Endpoints for managing books (`/books`).
- **Author Resource**: Endpoints for managing authors (`/authors`).
- **Customer Resource**: Endpoints for managing customers (`/customers`).
- **Cart Resource**: Endpoints for managing shopping carts (`/customers/{customerId}/cart`).
- **Order Resource**: Endpoints for managing orders (`/customers/{customerId}/orders`).



## Conclusion
All tests have passed successfully, and the API is functioning as expected. Responses are returned in a clean JSON format, and all activities are logged appropriately.

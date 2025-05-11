/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.resources;

/**
 *
 * @author isuru
 */
import BookStore.Services.OrderService;
import BookStore.models.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    
    private final OrderService orderService;
    
    public OrderResource() {
        this.orderService = new OrderService();
    }
    
    @POST
    public Response createOrder(@PathParam("customerId") int customerId) {
        try {
            Order order = orderService.createOrder(customerId);
            return Response.status(Response.Status.CREATED).entity(order).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error creating order: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    public Response getCustomerOrders(@PathParam("customerId") int customerId) {
        try {
            List<Order> orders = orderService.getCustomerOrders(customerId);
            return Response.status(Response.Status.OK).entity(orders).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/{orderId}")
    public Response getOrder(
            @PathParam("customerId") int customerId,
            @PathParam("orderId") int orderId) {
        try {
            Order order = orderService.getOrderById(customerId, orderId);
            return Response.status(Response.Status.OK).entity(order).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
}
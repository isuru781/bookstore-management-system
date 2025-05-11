/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.resources;

import BookStore.Services.CartService;
import BookStore.models.Cart;
import BookStore.models.CartItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author isuru
 */


@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {
  private final CartService cartService;
    
    public CartResource() {
        this.cartService = new CartService();
    }
    
    @GET
    public Response getCart(@PathParam("customerId") int customerId) {
        try {
            Cart cart = cartService.getCart(customerId);
            return Response.status(Response.Status.OK).entity(cart).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    @POST
    @Path("/items")
    public Response addItemToCart(
            @PathParam("customerId") int customerId,
            CartItem cartItem) {
        try {
            cartService.addItemToCart(customerId, cartItem);
            return Response.status(Response.Status.CREATED)
                    .entity("Item added to cart successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    @PUT
    @Path("/items/{bookId}")
    public Response updateCartItem(
            @PathParam("customerId") int customerId,
            @PathParam("bookId") int bookId,
            CartItem cartItem) {
        try {
            cartService.updateCartItem(customerId, bookId, cartItem.getQuantity());
            return Response.status(Response.Status.OK)
                    .entity("Item quantity updated successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    @DELETE
    @Path("/items/{bookId}")
    public Response removeCartItem(
            @PathParam("customerId") int customerId,
            @PathParam("bookId") int bookId) {
        try {
            cartService.removeCartItem(customerId, bookId);
            return Response.status(Response.Status.OK)
                    .entity("Item removed from cart successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }  
}

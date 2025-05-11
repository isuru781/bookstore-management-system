/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.resources;

import BookStore.Services.CustemerService;

import BookStore.models.Customer;
import java.util.List;
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





@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @POST
    public Response addCustomers(Customer customer) {
        CustemerService ser = new CustemerService();
        try {
            Customer response = ser.addCustomer(customer);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
    }

    @GET
    public Response getAllCustomers() {
        CustemerService ser = new CustemerService();
        try {
            List<Customer> res = ser.getCustomer();
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }

    }

    @GET
    @Path("/{id}")
    public Response getBooksId(@PathParam("id") Integer id) {
        CustemerService ser = new CustemerService();
        try {
            Customer res = ser.getCustomerById(id);
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {

            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response updateBooks(@PathParam("id") Integer id, Customer customer) {
        CustemerService ser = new CustemerService();

        try {
            Customer res = ser.EditCustomer(id, customer);
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {

            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }

    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Integer id) {
        CustemerService ser = new CustemerService();

        try {
            String res = ser.deleteAuthor(id);
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }

    }

}

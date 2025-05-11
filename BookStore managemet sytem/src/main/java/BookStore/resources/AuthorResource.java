package BookStore.resources;

import BookStore.Services.AutherServices;
import BookStore.models.Author;
import BookStore.models.Book;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
    
    @POST
    public Response addAuthor(Author author) {
        AutherServices ser = new AutherServices();
        try {
            Author response = ser.addAuthers(author);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
    }
    
    @GET
    public Response getAllAuthors() {
        AutherServices ser = new AutherServices();
        try {
            List<Author> res = ser.getAuthers();
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
        
    }
    
    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Integer id) {
        AutherServices ser = new AutherServices();
        try {
            Author res = ser.getAuthorById(id);
            return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            
             return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
        
    }
    
    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") Integer id,Author author) {
        AutherServices ser = new AutherServices();
        
        try {
            Author res = ser.EditAuthor(id, author);
        return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
        
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") Integer id) {
        AutherServices ser = new AutherServices();
        
        try {
            String res = ser.deleteAuthor(id);
        return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
        
    }
    
    @GET
    @Path("/{id}/books")
    public Response getAuthorBooks(@PathParam("id") Integer id) {
        AutherServices ser = new AutherServices();
        
        try {
            List<Book> res = ser.getAuthorBooks(id);
        return Response.status(Response.Status.OK).entity(res).build();
        } catch (Exception e) {
             return Response.status(Response.Status.NOT_FOUND)
                    .entity("had a error " + e)
                    .build();
        }
        
    }
}
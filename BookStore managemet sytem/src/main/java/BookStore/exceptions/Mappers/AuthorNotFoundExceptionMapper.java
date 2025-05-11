/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore.exceptions.Mappers;

import BookStore.exceptions.AuthorNotFoundException;
import BookStore.exceptions.ErrorResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author isuru
 */
@Provider
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {
    @Override
    public Response toResponse(AuthorNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
            "AUTHOR_NOT_FOUND", 
            exception.getMessage(), 
            Response.Status.NOT_FOUND.getStatusCode()
        );
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorResponse)
                .type("application/json")
                .build();
    }
}


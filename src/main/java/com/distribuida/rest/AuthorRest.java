package com.distribuida.rest;

import com.distribuida.db.Author;
import com.distribuida.servicios.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Path("/authors")
public class AuthorRest {

    @Inject
    AuthorService authorService;

    @GET
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GET
    @Path("/{id}")
    public Author findById(@PathParam("id")Long id){
        return authorService.findById(id);
    }

    @POST
    public Response createAuthor(Author author){
        authorService.createAuthor(author);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id")long id, Author author) throws Exception {
        authorService.updateAuthor(id, author);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id")long id){
        authorService.deleteAuthor(id);
        return Response.status(Response.Status.OK).build();
    }
}

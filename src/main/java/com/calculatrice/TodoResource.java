package com.calculatrice;

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

import java.util.List;

/**
 * REST resource for CRUD operations on TODO items.
 * Produces and consumes JSON.
 */
@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoService service = TodoService.getInstance();

    @GET
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        Todo todo = service.getById(id);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(todo).build();
    }

    @POST
    public Response create(Todo todo) {
        if (todo == null || todo.getTitre() == null || todo.getTitre().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Le titre est obligatoire"))
                    .build();
        }
        Todo created = service.create(todo);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Todo todo) {
        if (todo == null || todo.getTitre() == null || todo.getTitre().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Le titre est obligatoire"))
                    .build();
        }
        Todo updated = service.update(id, todo);
        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        boolean removed = service.delete(id);
        if (!removed) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}

package rest.todo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.todo.dao.TodoDao;
import rest.todo.model.Todo;

@Path("/todos")
public class TodoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getTodos() {
        return TodoDao.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodo(@PathParam("id") int id) {
        Todo todo = TodoDao.get(id);
        if (todo == null) {
            throw new NotFoundException("Todo with id " + id + " not found");
        }
        return todo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String createTodo(
            @FormParam("id") Integer id,
            @FormParam("title") String title,
            @FormParam("description") String description,
            @DefaultValue("false") @FormParam("done") boolean done) {

        if (title == null || title.trim().isEmpty()) {
            return "<html><body><h2>Title is required.</h2></body></html>";
        }

        int todoId = (id == null || id <= 0) ? TodoDao.nextId() : id;
        String normalizedDescription = (description == null || description.trim().isEmpty())
                ? null
                : description.trim();

        TodoDao.add(new Todo(todoId, title.trim(), done, normalizedDescription));

        return "<html><body><h2>Todo created with id " + todoId + ".</h2></body></html>";
    }
}

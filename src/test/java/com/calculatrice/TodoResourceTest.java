package com.calculatrice;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(TodoResource.class)
                .register(JacksonFeature.class);
    }

    @Test
    public void testGetAll() {
        Response response = target("/todos").request(MediaType.APPLICATION_JSON).get();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testGetByIdFound() {
        Response response = target("/todos/1").request(MediaType.APPLICATION_JSON).get();
        assertEquals(200, response.getStatus());
        Todo todo = response.readEntity(Todo.class);
        assertNotNull(todo);
        assertEquals(1, todo.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        Response response = target("/todos/999").request(MediaType.APPLICATION_JSON).get();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testCreate() {
        Todo newTodo = new Todo(0, "Test", "Description test", false);
        Response response = target("/todos")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newTodo, MediaType.APPLICATION_JSON));
        assertEquals(201, response.getStatus());
        Todo created = response.readEntity(Todo.class);
        assertNotNull(created);
        assertEquals("Test", created.getTitre());
    }

    @Test
    public void testCreateWithoutTitle() {
        Todo newTodo = new Todo(0, null, "Sans titre", false);
        Response response = target("/todos")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newTodo, MediaType.APPLICATION_JSON));
        assertEquals(400, response.getStatus());
    }

    @Test
    public void testUpdate() {
        Todo updated = new Todo(0, "Modifié", "Description modifiée", true);
        Response response = target("/todos/1")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(updated, MediaType.APPLICATION_JSON));
        assertEquals(200, response.getStatus());
        Todo result = response.readEntity(Todo.class);
        assertEquals("Modifié", result.getTitre());
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdateNotFound() {
        Todo updated = new Todo(0, "Inconnu", "Desc", false);
        Response response = target("/todos/999")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(updated, MediaType.APPLICATION_JSON));
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testDelete() {
        // First create one to delete
        Todo newTodo = new Todo(0, "À supprimer", "Sera supprimé", false);
        Response createResponse = target("/todos")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newTodo, MediaType.APPLICATION_JSON));
        Todo created = createResponse.readEntity(Todo.class);

        Response deleteResponse = target("/todos/" + created.getId())
                .request(MediaType.APPLICATION_JSON)
                .delete();
        assertEquals(204, deleteResponse.getStatus());
    }

    @Test
    public void testDeleteNotFound() {
        Response response = target("/todos/999")
                .request(MediaType.APPLICATION_JSON)
                .delete();
        assertEquals(404, response.getStatus());
    }
}

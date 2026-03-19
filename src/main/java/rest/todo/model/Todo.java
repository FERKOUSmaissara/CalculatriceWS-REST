package rest.todo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {

    private int id;
    private String title;
    private boolean done;
    private String description;

    public Todo() {
    }

    public Todo(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Todo(int id, String title, boolean done, String description) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

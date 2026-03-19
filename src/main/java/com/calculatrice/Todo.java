package com.calculatrice;

/**
 * Model class representing a TODO item.
 */
public class Todo {

    private int id;
    private String titre;
    private String description;
    private boolean complete;

    public Todo() {
    }

    public Todo(int id, String titre, String description, boolean complete) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}

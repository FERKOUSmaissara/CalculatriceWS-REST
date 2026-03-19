package com.calculatrice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In-memory service for managing TODO items.
 * Uses a singleton pattern so that data persists across requests.
 */
public class TodoService {

    private static final TodoService INSTANCE = new TodoService();
    private final List<Todo> todos = new CopyOnWriteArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private TodoService() {
        todos.add(new Todo(nextId.getAndIncrement(), "Apprendre REST", "Étudier les services REST avec Jersey", false));
        todos.add(new Todo(nextId.getAndIncrement(), "Créer un projet", "Implémenter CalculatriceWS-REST", true));
    }

    public static TodoService getInstance() {
        return INSTANCE;
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

    public Todo getById(int id) {
        return todos.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public Todo create(Todo todo) {
        todo.setId(nextId.getAndIncrement());
        todos.add(todo);
        return todo;
    }

    public synchronized Todo update(int id, Todo updated) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                updated.setId(id);
                todos.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        return todos.removeIf(t -> t.getId() == id);
    }
}

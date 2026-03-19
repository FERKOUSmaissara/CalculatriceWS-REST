package rest.todo.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rest.todo.model.Todo;

public class TodoDao {

    private static final Map<Integer, Todo> todos = new LinkedHashMap<Integer, Todo>();

    static {
        todos.put(1, new Todo(1, "Learn REST", false));
        todos.put(2, new Todo(2, "Do TD", true));
    }

    private TodoDao() {
    }

    public static List<Todo> getAll() {
        return new ArrayList<Todo>(todos.values());
    }

    public static Todo get(int id) {
        return todos.get(id);
    }

    public static void add(Todo todo) {
        todos.put(todo.getId(), todo);
    }

    public static int nextId() {
        int maxId = 0;
        for (Integer id : todos.keySet()) {
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }
}

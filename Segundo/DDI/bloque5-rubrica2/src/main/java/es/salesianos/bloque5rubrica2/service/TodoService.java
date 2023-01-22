package es.salesianos.bloque5rubrica2.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import es.salesianos.bloque5rubrica2.model.*;

@Service
public class TodoService {
	
    private static List<Todo> todos = new ArrayList<Todo>();

    static {
        todos.add(new Todo(1, "pvillarte", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "pvillarte", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "pvillarte", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
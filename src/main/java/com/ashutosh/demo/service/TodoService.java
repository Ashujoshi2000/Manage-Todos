package com.ashutosh.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ashutosh.demo.model.Todo;

@Service
public class TodoService {
    
    static int id = 0;

    private static List<Todo> todo = new ArrayList<>();

    static{
        todo.add(new Todo(++id, "Ashu", "Learn Spring Boot", LocalDate.now().plusWeeks(3), false));
        todo.add(new Todo(++id, "Ashu", "Learn React.js", LocalDate.now().plusWeeks(8), false));
        todo.add(new Todo(++id, "Ashu", "Crack Interview", LocalDate.now().plusWeeks(10), false));
    }

    public List<Todo> getTodoByUserName(String userName) {
        Predicate<? super Todo> Predicate = todo->todo.getName().equalsIgnoreCase(userName);
        return todo.stream().filter(Predicate).toList();
    }

    public void addTodos(String name, String desc, LocalDate date){
        Todo todo2 = new Todo(++id, name, desc, date, false);
        todo.add(todo2);
    }

    public void deleteTodo(int id){
        Predicate<? super Todo> Predicate = todo->todo.getId()==id;
        todo.removeIf(Predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> Predicate = todo->todo.getId()==id;
        Todo todo1 = todo.stream().filter(Predicate).findFirst().get();
        return todo1;
    }

    public void updateTodos(Todo todo2) {
        deleteTodo(todo2.getId());
        todo.add(todo2);
    }
}

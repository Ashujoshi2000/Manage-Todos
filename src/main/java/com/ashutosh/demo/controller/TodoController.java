package com.ashutosh.demo.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashutosh.demo.TodoRepository;
import com.ashutosh.demo.model.Todo;
import com.ashutosh.demo.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/todo")
    public String getTodos(ModelMap model){
        String name = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.getTodoByName(name);
        //List<Todo> todos = todoService.getTodoByUserName(userName);
        model.addAttribute("todos", todos);
        return "ListTodos";
    }

    @RequestMapping("/add-todo")
    public String addTodo(ModelMap model){
        String userName = getLoggedInUsername(model);
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusWeeks(5), false);
        model.put("todo", todo);
        return "AddTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodos(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "AddTodo";
        }
        todoRepository.save(todo);
        //todoService.addTodos(todo.getName(),todo.getDesc(),todo.getDate());
        return "redirect:todo";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        //todoService.deleteTodo(id);
        return "redirect:todo";
    }

    @RequestMapping("update-todo")
    public String updateTodo(@RequestParam int id, ModelMap model){
        //Todo todo = todoService.findById(id);
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "AddTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodos(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "AddTodo";
        }
        todoRepository.save(todo);
        //todoService.updateTodos(todo);
        return "redirect:todo";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    
}

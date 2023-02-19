package com.ashutosh.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.demo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{

    public List<Todo> getTodoByName(String name);
    
}

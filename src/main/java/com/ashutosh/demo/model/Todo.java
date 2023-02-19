package com.ashutosh.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Size(min = 5, message = "Enter atleast 5 characters")
    private String description;
    private LocalDate targetDate;
    private boolean isDone;

    Todo(){

    }
    
    public Todo(int id, String name, String description, LocalDate date, boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetDate = date;
        this.isDone = isDone;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(LocalDate date) {
        this.targetDate = date;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", description=" + description + ", date=" + targetDate + ", isDone=" + isDone + "]";
    }

    
}

package com.example.youDo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;


import java.util.Date;

@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private String task;
    private int priority;
    private String description;
    private Date due;
    private String status;
    @CreatedDate
    private Date createdAt; // New field


    // Constructors, getters, setters

    public Task() {
        this.createdAt = new Date(); // Set current date/time during object creation
    }

    public Task(String task, int priority, String description, Date due, String status) {
        this.task = task;
        this.priority = priority;
        this.description = description;
        this.due = due;
        this.status = status;
        this.createdAt = new Date(); // Set current date/time during object creation
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}


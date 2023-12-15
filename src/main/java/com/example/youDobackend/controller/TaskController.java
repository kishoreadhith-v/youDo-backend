package com.example.youDobackend.controller;


import com.example.youDobackend.model.Task;
import com.example.youDobackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{userId}")
    public List<Task> getUserTasks(@PathVariable String userId) {
        return taskRepository.findByUserId(userId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Update existingTask with fields from updatedTask
        existingTask.setTask(updatedTask.getTask());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDue(updatedTask.getDue());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask);
    }

    // Add other task-related operations as needed
}


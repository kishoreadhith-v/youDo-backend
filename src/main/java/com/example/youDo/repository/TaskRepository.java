package com.example.youDo.repository;


import com.example.youDo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    // Custom query methods can be added here if needed

    List<Task> findByStatus(String status);
}


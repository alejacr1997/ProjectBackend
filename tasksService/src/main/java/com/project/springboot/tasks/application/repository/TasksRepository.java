package com.project.springboot.tasks.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.springboot.tasks.application.model.Task;

public interface TasksRepository extends MongoRepository<Task, String>{

	List<Task> findByUsername(String username);
}

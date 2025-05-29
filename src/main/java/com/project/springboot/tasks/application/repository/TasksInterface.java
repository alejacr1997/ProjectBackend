package com.project.springboot.tasks.application.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.springboot.tasks.application.model.Task;

public interface TasksInterface extends MongoRepository<Task, Long>{

	Task findByTitle(String title);
}

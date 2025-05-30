package com.project.springboot.tasks.application.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.springboot.tasks.application.model.CreateTaskRequest;
import com.project.springboot.tasks.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.tasks.application.model.DeleteTaskById;
import com.project.springboot.tasks.application.model.GetTaskByIdRequest;
import com.project.springboot.tasks.application.model.GetTasksForUserRequest;
import com.project.springboot.tasks.application.model.Task;
import com.project.springboot.tasks.application.model.UpdateTaskRequest;
import com.project.springboot.tasks.application.repository.TasksRepository;
import com.project.springboot.tasks.commons.exceptions.NoTaskWithId;
import com.project.springboot.tasks.commons.exceptions.NoTasksForUsername;
import com.project.springboot.tasks.commons.utils.Utils;

public class TaskServiceImpl implements TaskService{

	@Autowired
	TasksRepository repository;
	
	@Autowired
	Utils utils;
	
	@Override
	public String createTask(CreateTaskRequest request) {
		Task task = new Task();
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setUsername(request.getUsername());
		task.setStatus(false);
		task.setDueDate(request.getDueDate());
		task.setCreationDate(new Date());
		Task save = repository.save(task);
		return save.getId();
	}

	@Override
	public List<Task> getTasksForUser(GetTasksForUserRequest request) {
		List<Task> byUsername = repository.findByUsername(request.getUsername());
		if(byUsername.size() == 0) {
			throw new NoTasksForUsername("No Tasks Found For That Username");
		}
		return byUsername;
	}

	@Override
	public String updateTaskRequest(UpdateTaskRequest request) {
		Optional<Task> byId = repository.findById(request.getId());
		if(!byId.isPresent()) {
			throw new NoTaskWithId("No Task With Id:  "+request.getId());
		}
		Task save = repository.save(utils.updateFields(request, byId.get()));
		return save.getId();
	}

	@Override
	public Task getTaskById(GetTaskByIdRequest request) {
		Optional<Task> byId = repository.findById(request.getId());
		if(!byId.isPresent()) {
			throw new NoTaskWithId("No Task With Id:  "+request.getId());
		}
		return byId.get();
	}

	@Override
	public String deleteTaskById(DeleteTaskById request) {
		repository.deleteById(request.getId());
		return "Task With Id: "+request.getId()+" Was Deleted";
	}

	@Override
	public String deleteTasksForUser(DeleteAllTasksUserRequest request) {
		List<Task> byUsername = repository.findByUsername(request.getUsername());
		if(byUsername.size() == 0) {
			throw new NoTasksForUsername("No Tasks Found For That Username");
		}
		byUsername.stream().forEach(item -> repository.deleteById(item.getId()));
		return "All Tasks for User : "+request.getUsername()+" Were Deleted";
	}

}

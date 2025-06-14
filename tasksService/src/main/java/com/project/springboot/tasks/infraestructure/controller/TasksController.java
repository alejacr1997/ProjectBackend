package com.project.springboot.tasks.infraestructure.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.tasks.application.model.CreateTaskRequest;
import com.project.springboot.tasks.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.tasks.application.model.DeleteTaskById;
import com.project.springboot.tasks.application.model.GetTaskByIdRequest;
import com.project.springboot.tasks.application.model.GetTasksForUserRequest;
import com.project.springboot.tasks.application.model.UpdateTaskRequest;
import com.project.springboot.tasks.application.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks/")
public class TasksController {

	@Autowired
	TaskService service;
	
	@PostMapping("createTask")
	public ResponseEntity<?> createTask(@Valid @RequestBody CreateTaskRequest request, BindingResult result) throws BadRequestException {
		if (result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Create Task");
		}
		return ResponseEntity.ok(service.createTask(request));
	}
	
	@GetMapping("getTasksUser")
	public ResponseEntity<?> getTasksForUser(@Valid @ModelAttribute GetTasksForUserRequest request, BindingResult result) throws BadRequestException{
		if (result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get Tasks For User");
		}
		return ResponseEntity.ok(service.getTasksForUser(request));
	}
	
	@PutMapping("updateTask")
	public ResponseEntity<?> updateTask(@Valid @RequestBody UpdateTaskRequest request, BindingResult result) throws BadRequestException {
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Update Task");
		}
		return ResponseEntity.ok(service.updateTaskRequest(request));
	}
	
	@GetMapping("getTaskId")
	public ResponseEntity<?> getTaskById(@Valid @ModelAttribute GetTaskByIdRequest request, BindingResult result) throws BadRequestException {
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get Task By Id");
		}
		return ResponseEntity.ok(service.getTaskById(request));
	}
	
	@DeleteMapping("deleteTaskId")
	public ResponseEntity<?> deleteTaskBtId(@Valid @RequestBody DeleteTaskById request, BindingResult result) throws BadRequestException {
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Delete Task By Id");
		}
		return ResponseEntity.ok(service.deleteTaskById(request));
	}
	
	@DeleteMapping("deleteTaskUser")
	public ResponseEntity<?> deleteTaskForUser(@Valid @RequestBody DeleteAllTasksUserRequest request, BindingResult result) throws BadRequestException {
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Delete Task By Id");
		}
		return ResponseEntity.ok(service.deleteTasksForUser(request));
	}
	
}

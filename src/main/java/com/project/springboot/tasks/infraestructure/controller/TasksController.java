package com.project.springboot.tasks.infraestructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks/")
public class TasksController {

	@PostMapping("createTask")
	public String createTask() {
		return "OK";
	}
	
}

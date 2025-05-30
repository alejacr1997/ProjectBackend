package com.project.springboot.tasks.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.tasks.application.model.CreateTaskRequest;
import com.project.springboot.tasks.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.tasks.application.model.DeleteTaskById;
import com.project.springboot.tasks.application.model.GetTaskByIdRequest;
import com.project.springboot.tasks.application.model.GetTasksForUserRequest;
import com.project.springboot.tasks.application.model.Task;
import com.project.springboot.tasks.application.model.UpdateTaskRequest;

@Service
public interface TaskService {

	public String createTask(CreateTaskRequest request);
	
	public List<Task> getTasksForUser(GetTasksForUserRequest request);
	
	public String updateTaskRequest(UpdateTaskRequest request);
	
	public Task getTaskById(GetTaskByIdRequest request);
	
	public String deleteTaskById(DeleteTaskById request);
	
	public String deleteTasksForUser(DeleteAllTasksUserRequest request);
	
}

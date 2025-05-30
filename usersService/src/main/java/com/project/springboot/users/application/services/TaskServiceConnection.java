package com.project.springboot.users.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.users.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.users.application.model.GetTasksForUserRequest;
import com.project.springboot.users.application.model.Task;

@Service
public interface TaskServiceConnection {

	public List<Task> getTasksForUser(GetTasksForUserRequest request);
	
	public String deleteTasksOfUser(DeleteAllTasksUserRequest request);
	
}

package com.project.springboot.tasks.commons.utils;

import com.project.springboot.tasks.application.model.Task;
import com.project.springboot.tasks.application.model.UpdateTaskRequest;

public class Utils {

	public Task updateFields(UpdateTaskRequest request, Task task){
		if(request.getDueDate() != null) 
			task.setDueDate(request.getDueDate());
		if(request.getDescription() != null && !request.getDescription().isEmpty())
			task.setDescription(request.getDescription());
		if(request.getTitle() != null && !request.getTitle().isEmpty())
			task.setTitle(request.getTitle());
		if(!task.isStatus()) 
			task.setStatus(request.isStatus());
		return task;
	}
}

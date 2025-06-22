package com.project.springboot.tasks.commons.utils;

import com.project.springboot.tasks.application.model.Task;
import com.project.springboot.tasks.application.model.UpdateTaskRequest;

public class Utils {

	public Task updateFields(UpdateTaskRequest request, Task task){
		if(request.getDueDate() != null) 
			task.setDueDate(request.getDueDate());
		if(request.getTitle() != null && !request.getTitle().isEmpty())
			task.setTitle(request.getTitle());
		return task;
	}
}

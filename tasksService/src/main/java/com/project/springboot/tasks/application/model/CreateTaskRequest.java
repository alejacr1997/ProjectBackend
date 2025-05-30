package com.project.springboot.tasks.application.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTaskRequest {

	@NotBlank
	@NotNull
	private String username;
	@NotNull
	@NotBlank
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;
	
}

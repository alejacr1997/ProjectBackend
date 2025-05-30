package com.project.springboot.tasks.application.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskRequest {

	@NotNull
	@NotBlank
	private String id;
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;
}

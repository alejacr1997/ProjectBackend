package com.project.springboot.tasks.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetTasksForUserRequest {

	@NotBlank
	@NotNull
	private String username;
}

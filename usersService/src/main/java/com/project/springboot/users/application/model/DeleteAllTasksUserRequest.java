package com.project.springboot.users.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteAllTasksUserRequest {

	@NotBlank
	@NotNull
	private String username;
}

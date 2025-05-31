package com.project.springboot.tasks.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExistUsernameRequest {

	@NotNull
	@NotBlank
	private String username;
}

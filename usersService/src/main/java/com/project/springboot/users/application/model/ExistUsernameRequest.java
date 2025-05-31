package com.project.springboot.users.application.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExistUsernameRequest {

	@NotNull
	@NotBlank
	private String username;
}

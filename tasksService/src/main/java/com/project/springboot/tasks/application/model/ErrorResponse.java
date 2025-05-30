package com.project.springboot.tasks.application.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	private String codeError;
	private String messageError;
}

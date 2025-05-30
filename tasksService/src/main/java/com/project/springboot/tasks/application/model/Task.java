package com.project.springboot.tasks.application.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Document(collection = "tasks")
@Data
public class Task {
	
	@Id
	private String idUsuario;
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;
	private Date creationDate;

}

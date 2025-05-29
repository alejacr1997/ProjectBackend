package com.project.springboot.tasks.application.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "tasks")
@Data
public class Task {
	
	@Id
	private Long idUsuario;
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;

}

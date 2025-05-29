package com.project.springboot.users.application.model;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class GetUserByIdRequest {
	
	@Min(1)
	private Long id;
	
}

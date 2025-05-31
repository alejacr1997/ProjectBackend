package com.project.springboot.tasks.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.springboot.tasks.application.services.TaskService;
import com.project.springboot.tasks.application.services.TaskServiceImpl;
import com.project.springboot.tasks.application.services.UserServiceConnection;
import com.project.springboot.tasks.application.services.UserServiceConnectionImpl;
import com.project.springboot.tasks.commons.utils.Utils;

@Configuration
public class TaskConfig {
	
	@Bean
	public TaskService taskService() {
		return new TaskServiceImpl();
	}
	
	@Bean
	public Utils utils() {
		return new Utils();
	}
	
	@Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
	
	@Bean
	public UserServiceConnection userServiceConnection() {
		return new UserServiceConnectionImpl();
	}

}

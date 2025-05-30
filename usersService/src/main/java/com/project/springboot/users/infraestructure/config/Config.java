package com.project.springboot.users.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.springboot.users.application.services.TaskServiceConnection;
import com.project.springboot.users.application.services.TaskServiceConnectionImpl;
import com.project.springboot.users.application.services.UserService;
import com.project.springboot.users.application.services.UserServiceImpl;
import com.project.springboot.users.commons.utils.Utils;

@Configuration
public class Config {
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
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
	public TaskServiceConnection taskServiceConnection(){
		return new TaskServiceConnectionImpl();
	}

}

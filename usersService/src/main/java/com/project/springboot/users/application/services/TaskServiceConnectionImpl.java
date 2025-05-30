package com.project.springboot.users.application.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.springboot.users.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.users.application.model.GetTasksForUserRequest;
import com.project.springboot.users.application.model.Task;

import reactor.core.publisher.Mono;

public class TaskServiceConnectionImpl implements TaskServiceConnection {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${url.task.service}")
	private String urlTaskService;
	
	@Value("${path.get.task.user}")
	private String pathGetTaskForUser;
	
	@Value("${path.delete.task.user}")
	private String pathDeleteTaskForUser;
	
	Logger logger = LoggerFactory.getLogger(TaskServiceConnectionImpl.class);
	
	@Override
	public List<Task> getTasksForUser(GetTasksForUserRequest request) {
		WebClient webClient = webClientBuilder.baseUrl(urlTaskService).build();
		try {
			Mono<List<Task>> bodyToMono = webClient.method(HttpMethod.GET)
					.uri(uriBuilder -> 
						uriBuilder.path(pathGetTaskForUser)
						.queryParam("username", request.getUsername())
						.build()
					)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Task>>() {});
			return bodyToMono.block();
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ArrayList<Task>();
		}
		
	}

	@Override
	public String deleteTasksOfUser(DeleteAllTasksUserRequest request) {
		WebClient webClient = webClientBuilder.baseUrl(urlTaskService).build();
		Mono<String> bodyToMono = webClient.method(HttpMethod.DELETE)
									.uri(pathDeleteTaskForUser)
									.bodyValue(request)
									.retrieve()
									.bodyToMono(String.class);
		return bodyToMono.block();
	}

}

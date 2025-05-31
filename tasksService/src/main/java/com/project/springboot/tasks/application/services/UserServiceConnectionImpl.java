package com.project.springboot.tasks.application.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.springboot.tasks.application.model.ExistUsernameRequest;
import com.project.springboot.tasks.commons.exceptions.UserDoesNotExist;

import reactor.core.publisher.Mono;

public class UserServiceConnectionImpl implements UserServiceConnection {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${url.user.service}")
	private String urlUser;
	
	@Value("${path.user.existUsername}")
	private String pathExists;
	
	Logger logger = LoggerFactory.getLogger(UserServiceConnectionImpl.class);
	
	@Override
	public boolean existUsername(ExistUsernameRequest request) {
		WebClient webClient = webClientBuilder.baseUrl(urlUser).build();
		try {
			 Mono<Boolean> bodyToMono = webClient.method(HttpMethod.GET)
					.uri(uriBuilder -> 
						uriBuilder.path(pathExists)
						.queryParam("username", request.getUsername())
						.build()
					)
					.retrieve()
					.bodyToMono(Boolean.class);
			return bodyToMono.block();
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new UserDoesNotExist("User does not exist, can not create task");
		}
	}

}

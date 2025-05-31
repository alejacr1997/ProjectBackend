package com.project.springboot.tasks.commons.exceptions;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.springboot.tasks.application.model.ErrorResponse;


@RestControllerAdvice
public class CustomExceptionsHandler {
	
	Logger logger = LoggerFactory.getLogger(CustomExceptionsHandler.class);
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException request){
		logger.error("bad request exception");
		ErrorResponse response = new ErrorResponse("ERR001", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoTasksForUsername.class)
	public ResponseEntity<ErrorResponse> handleNoTasksForUsername(NoTasksForUsername request){
		logger.error("no tasks for username");
		ErrorResponse response = new ErrorResponse("ERR002", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoTaskWithId.class)
	public ResponseEntity<ErrorResponse> handleNoTasksWithId(NoTaskWithId request){
		logger.error("no tasks with id");
		ErrorResponse response = new ErrorResponse("ERR003", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserDoesNotExist.class)
	public ResponseEntity<ErrorResponse> handleUserDoesNotExist(UserDoesNotExist request){
		logger.error("username does not exist");
		ErrorResponse response = new ErrorResponse("ERR004", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
}

package com.project.springboot.users.commons.exceptions;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.springboot.users.application.model.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionsHandler {
	
	Logger logger = LoggerFactory.getLogger(CustomExceptionsHandler.class);
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException request){
		logger.error("bad request exception");
		ErrorResponse response = new ErrorResponse("ERR001", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExists request){
		logger.error("user already exists");
		ErrorResponse response = new ErrorResponse("ERR002", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserDoesNotExists.class)
	public ResponseEntity<ErrorResponse> handleUserDoesNotExists(UserDoesNotExists request){
		logger.error("user does not exists");
		ErrorResponse response = new ErrorResponse("ERR003", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoUsersCreated.class)
	public ResponseEntity<ErrorResponse> handleNoUsersCreated(NoUsersCreated request){
		logger.error("user does not exists");
		ErrorResponse response = new ErrorResponse("ERR004", request.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
}

package com.project.springboot.users.infraestructure.controller;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.users.application.model.DeleteUserByIdRequest;
import com.project.springboot.users.application.model.ExistUsernameRequest;
import com.project.springboot.users.application.model.GetUserByIdRequest;
import com.project.springboot.users.application.model.GetUserByUsernameRequest;
import com.project.springboot.users.application.model.SaveUserRequest;
import com.project.springboot.users.application.model.UpdateUserRequest;
import com.project.springboot.users.application.services.UserService;
import com.project.springboot.users.commons.utils.Utils;

import jakarta.validation.Valid;

@RequestMapping("/users/")
@RestController
public class UsersController {

	@Autowired
	UserService service;
	
	@Autowired
	Utils utils;
	
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@PostMapping("createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody SaveUserRequest request, BindingResult result) throws BadRequestException{
		logger.info("Enter Create User");
		if (result.hasErrors() || !utils.validatePassword(request.getPassword())) {
			throw new BadRequestException("Bad Request Service Save User");
		}
		return ResponseEntity.ok(service.createUser(request));
	}
	
	@GetMapping("getUserById")
	public ResponseEntity<?> getUserById(@Valid @ModelAttribute GetUserByIdRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Get User By Id:  {}",request.getId());
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return ResponseEntity.ok(service.getUser(request.getId()));
	}
	
	@PutMapping("updateUser")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Update User");
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		 return ResponseEntity.ok(service.updateUser(request));
	}
	
	@GetMapping("getUserByUsername")
	public ResponseEntity<?> getUserByUsername(@Valid @ModelAttribute GetUserByUsernameRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Get User By Username");
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return ResponseEntity.ok(service.getUserByUsername(request));
	}
	
	@DeleteMapping("deleteUser")
	public ResponseEntity<?> deleteUserById(@Valid @RequestBody DeleteUserByIdRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Delete User By Id {}",request.getId());
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return ResponseEntity.ok(service.deleteUser(request));
	}
	
	@GetMapping("getAllUsers")
	public ResponseEntity<?> getAllUsers(){
		logger.info("Enter Get All Users");
		return ResponseEntity.ok(service.getAllUsers());
	} 
	
	@GetMapping("existUsername")
	public ResponseEntity<?> existUsername(@Valid @ModelAttribute ExistUsernameRequest request, BindingResult result) throws BadRequestException{
		logger.info("Enter Exist Username: {}",request.getUsername());
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Exists Username");
		}
		return ResponseEntity.ok(service.existUsername(request.getUsername()));
	}
	
	
	
}

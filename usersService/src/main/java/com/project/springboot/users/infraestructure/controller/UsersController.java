package com.project.springboot.users.infraestructure.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.springboot.users.application.model.GetUserByIdRequest;
import com.project.springboot.users.application.model.GetUserByUsernameRequest;
import com.project.springboot.users.application.model.SaveUserRequest;
import com.project.springboot.users.application.model.UpdateUserRequest;
import com.project.springboot.users.application.model.User;
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
	public String createUser(@Valid @RequestBody SaveUserRequest request, BindingResult result) throws BadRequestException{
		logger.info("Enter Create User");
		if (result.hasErrors() || !utils.validatePassword(request.getPassword())) {
			throw new BadRequestException("Bad Request Service Save User");
		}
		return service.createUser(request);
	}
	
	@GetMapping("getUserById")
	public User getUserById(@Valid @ModelAttribute GetUserByIdRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Get User By Id:  {}",request.getId());
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return service.getUser(request.getId());
	}
	
	@PutMapping("updateUser")
	public String updateUser(@Valid @RequestBody UpdateUserRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Update User");
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		 return service.updateUser(request);
	}
	
	@GetMapping("getUserByUsername")
	public User getUserByUsername(@Valid @ModelAttribute GetUserByUsernameRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Get User By Username");
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return service.getUserByUsername(request);
	}
	
	@DeleteMapping("deleteUser")
	public String deleteUserById(@Valid @RequestBody DeleteUserByIdRequest request, BindingResult result) throws BadRequestException {
		logger.info("Enter Delete User By Id {}",request.getId());
		if(result.hasErrors()) {
			throw new BadRequestException("Bad Request Service Get User By ID");
		}
		return service.deleteUser(request);
	}
	
	@GetMapping("getAllUsers")
	public List<User> getAllUsers(){
		logger.info("Enter Get All Users");
		return service.getAllUsers();
	}
	
	
	
}

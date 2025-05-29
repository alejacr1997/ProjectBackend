package com.project.springboot.users.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.users.application.model.DeleteUserByIdRequest;
import com.project.springboot.users.application.model.GetUserByUsernameRequest;
import com.project.springboot.users.application.model.SaveUserRequest;
import com.project.springboot.users.application.model.UpdateUserRequest;
import com.project.springboot.users.application.model.User;

import jakarta.validation.Valid;

@Service
public interface UserService {

	public String createUser(SaveUserRequest request);
	
	public User getUser(Long id);
	
	public String deleteUser(@Valid DeleteUserByIdRequest request);
	
	public String updateUser(UpdateUserRequest request);
	
	public User getUserByUsername(GetUserByUsernameRequest request);
	
	public List<User> getAllUsers();
	
	
}

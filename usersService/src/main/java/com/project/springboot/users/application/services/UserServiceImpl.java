package com.project.springboot.users.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.springboot.users.application.model.CompleteUser;
import com.project.springboot.users.application.model.DeleteAllTasksUserRequest;
import com.project.springboot.users.application.model.DeleteUserByIdRequest;
import com.project.springboot.users.application.model.GetTasksForUserRequest;
import com.project.springboot.users.application.model.GetUserByUsernameRequest;
import com.project.springboot.users.application.model.SaveUserRequest;
import com.project.springboot.users.application.model.Task;
import com.project.springboot.users.application.model.UpdateUserRequest;
import com.project.springboot.users.application.model.User;
import com.project.springboot.users.application.repository.UserDatabaseRepository;
import com.project.springboot.users.commons.exceptions.NoUsersCreated;
import com.project.springboot.users.commons.exceptions.UserAlreadyExists;
import com.project.springboot.users.commons.exceptions.UserDoesNotExists;
import com.project.springboot.users.commons.utils.Utils;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDatabaseRepository repository;
	
	@Autowired
	TaskServiceConnection taskService;
	
	@Autowired
	Utils utils;
	
	@Override
	public String createUser(SaveUserRequest request) {
		if(existUsername(request.getUsername())) {
			throw new UserAlreadyExists("Username Already Exists Can Not Be Created");
		}
		User user = new User();
		user.setUsername(request.getUsername());
		user.setName(utils.getFullName(request.getFirstname(), request.getMiddlename()));
		user.setLastname(request.getLastname());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setSex(request.getSex());
		user.setAge(request.getAge());
		User save = repository.save(user);
		return save.getUsername();
	}

	@Override
	public CompleteUser getUser(Long id) {
		Optional<User> optionalUser = repository.findById(id);
		if (optionalUser.isEmpty()) {
			throw new UserDoesNotExists("Can Not Get User It Does Not Exist");
		}
		User user = optionalUser.get();
		GetTasksForUserRequest request = new GetTasksForUserRequest(user.getUsername());
		List<Task> tasks = taskService.getTasksForUser(request);
		return new CompleteUser(user, tasks);
	}

	@Override
	public String updateUser(UpdateUserRequest request) {
		User user = new User();
		user.setId(request.getId());
		user.setUsername(request.getUsername());
		user.setName(utils.getFullName(request.getFirstname(), request.getMiddlename()));
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		user.setSex(request.getSex());
		user.setPassword(getPassword(request.getId()));
		User save = repository.save(user);
		return save.getUsername();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Iterable<User> all = repository.findAll();
		if (!all.iterator().hasNext()) {
			throw new NoUsersCreated("No Users Found In Database");
		}
		all.forEach(item -> users.add(item));
		return users;
	}
	
	@Override
	public boolean existUsername(String username) {
		return repository.existsByUsername(username);
	}

	@Override
	public String deleteUser(DeleteUserByIdRequest request) {
		Optional<User> byId = repository.findById(request.getId());
		if (!byId.isPresent()) {
			throw new UserDoesNotExists("User with id: "+request.getId()+" does not exist");
		}
		User user = byId.get();
		repository.deleteById(request.getId());
		String responseTask = taskService.deleteTasksOfUser(new DeleteAllTasksUserRequest(user.getUsername()));
		return "User with id: "+request.getId()+" eliminated and " + responseTask;
	}

	@Override
	public CompleteUser getUserByUsername(GetUserByUsernameRequest request) {
		User byUsername = repository.findByUsername(request.getUsername());
		if (byUsername == null) {
			throw new UserDoesNotExists("User: "+request.getUsername()+" not found in the database");
		}
		GetTasksForUserRequest requestTask = new GetTasksForUserRequest(byUsername.getUsername());
		List<Task> tasks = taskService.getTasksForUser(requestTask);
		return new CompleteUser(byUsername, tasks);
	}

	public String getPassword(Long id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get().getPassword();
		}
		throw new UserDoesNotExists("User does not exist, it can not be updated or found");
	}

	

}

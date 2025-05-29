package com.project.springboot.users.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.springboot.users.application.model.DeleteUserByIdRequest;
import com.project.springboot.users.application.model.GetUserByUsernameRequest;
import com.project.springboot.users.application.model.SaveUserRequest;
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
	Utils utils;
	
	@Override
	public String createUser(SaveUserRequest request) {
		if(validateUser(request.getUsername())) {
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
	public User getUser(Long id) {
		Optional<User> optionalUser = repository.findById(id);
		if (optionalUser.isEmpty()) {
			throw new UserDoesNotExists("Can Not Get User It Does Not Exist");
		}
		return optionalUser.get();
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
			throw new NoUsersCreated("No existen usuarios en la base de datos");
		}
		all.forEach(item -> users.add(item));
		return users;
	}
	
	private boolean validateUser(String username) {
		return repository.existsByUsername(username);
	}

	@Override
	public String deleteUser(DeleteUserByIdRequest request) {
		repository.deleteById(request.getId());
		return "Usuario con id: "+request.getId()+" eliminado";
	}

	@Override
	public User getUserByUsername(GetUserByUsernameRequest request) {
		User byUsername = repository.findByUsername(request.getUsername());
		if (byUsername == null) {
			throw new UserDoesNotExists("Usuario: "+request.getUsername()+" No existe en la base de datos");
		}
		return byUsername;
	}

	public String getPassword(Long id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get().getPassword();
		}
		throw new UserDoesNotExists("Usuario no ha sido creado, no puede ser actualizado ni consultado");
	}

	

}

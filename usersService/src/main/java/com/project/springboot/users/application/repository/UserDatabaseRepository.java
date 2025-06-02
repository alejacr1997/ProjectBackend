package com.project.springboot.users.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springboot.users.application.model.User;

public interface UserDatabaseRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
}

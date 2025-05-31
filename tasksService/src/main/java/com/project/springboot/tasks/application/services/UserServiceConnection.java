package com.project.springboot.tasks.application.services;

import com.project.springboot.tasks.application.model.ExistUsernameRequest;

public interface UserServiceConnection {

	public boolean existUsername(ExistUsernameRequest request);
}

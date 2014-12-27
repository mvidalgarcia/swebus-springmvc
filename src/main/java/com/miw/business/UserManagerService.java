package com.miw.business;

import com.miw.model.User;

public interface UserManagerService {
	public boolean isUser(User user) throws Exception;

	public User newUser(User user) throws Exception;
}

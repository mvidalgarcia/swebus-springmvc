package com.miw.business;

import com.miw.model.User;

public interface UserManagerService {
	public boolean isUser(User user) throws Exception;

	public boolean newUser(User user) throws Exception;
	
	public Integer findIdUserByEmail(String email) throws Exception;
}

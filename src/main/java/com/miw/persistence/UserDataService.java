package com.miw.persistence;

import com.miw.model.User;

public interface UserDataService {
		public boolean isUser(User user) throws Exception;
		public User newUser(User user) throws Exception;

}



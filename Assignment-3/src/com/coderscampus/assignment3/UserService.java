package com.coderscampus.assignment3;

public class UserService {

	public User isUser(String username, String password, String name) {
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setName(name);
		return user;
		
	}
}

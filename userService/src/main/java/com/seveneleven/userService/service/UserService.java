package com.seveneleven.userService.service;

import java.util.List;

import com.seveneleven.userService.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(long id);
	
	public User saveUser(User user);
	
	public String deleteUserById(long id);

}

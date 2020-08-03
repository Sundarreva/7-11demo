package com.seveneleven.userService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.userService.model.User;
import com.seveneleven.userService.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public List<User> getAllUser(){
		
		LOGGER.info("Start");
		return userService.getAllUsers();
	}
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable long id) {
		
		LOGGER.info("Start");
		return userService.getUserById(id);
	}
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody User user) {
		
		LOGGER.info("Start");
		return userService.saveUser(user);
	}
	

	@DeleteMapping("/id/{id}")
	public String deleteUserById(@PathVariable long id) {
		
		LOGGER.info("Start");
		return userService.deleteUserById(id);
	}
	

}

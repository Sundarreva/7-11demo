package com.seveneleven.userService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.seveneleven.userService.exception.UserAlreadyExistException;
import com.seveneleven.userService.model.User;
import com.seveneleven.userService.repository.RoleRepository;
import com.seveneleven.userService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	RoleRepository roleRepository;
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		
		LOGGER.info("Start");
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		
		LOGGER.info("Start");
		return userRepository.findById(id).get();
	}

	@Override
	@Transactional
	public User saveUser(User user) throws UserAlreadyExistException {
		LOGGER.info("Start");
		LOGGER.debug("user {}", user);
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(userRepository.findByName(user.getName()) != null) {
			LOGGER.info("User exist Exception");
			throw new UserAlreadyExistException("User already exist");
		}
		
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(roleRepository.findById(2l).get());
		
		LOGGER.info("Signup Successfull");
		LOGGER.debug("user {}", user);
		
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public String deleteUserById(long id) {
		
		LOGGER.info("Start");
		userRepository.deleteById(id);
		return "Deleted Successfully";
	}

}

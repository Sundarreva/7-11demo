package com.seveneleven.zuulgateway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seveneleven.zuulgateway.model.User;
import com.seveneleven.zuulgateway.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("START");
		LOGGER.info("LOAD BY USERNAME");
		LOGGER.debug("Username from parameter: {}" , username);
		User user = userRepository.findByName(username);
		LOGGER.debug("User: {}" , user);
		UserDetails appUser;

		if (user != null) {
			appUser = new AppUser(user);
		}else {
			LOGGER.debug("USERNAME NOT FOUND EXCEPTION");
			throw new UsernameNotFoundException("Username Not Found");
		}
		
		LOGGER.debug("Role: {}", user.getRole());
		LOGGER.debug("Username: {}", appUser.getUsername());
		LOGGER.debug("Password: {}", appUser.getPassword());
		LOGGER.info("END");
		return appUser;
	}

}
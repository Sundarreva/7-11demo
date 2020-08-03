package com.seveneleven.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seveneleven.userService.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByName(String name);
}

package com.seveneleven.zuulgateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seveneleven.zuulgateway.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByName(String name);

}

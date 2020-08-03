package com.seveneleven.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seveneleven.userService.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

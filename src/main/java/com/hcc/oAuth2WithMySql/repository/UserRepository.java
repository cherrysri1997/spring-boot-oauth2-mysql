package com.hcc.oAuth2WithMySql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcc.oAuth2WithMySql.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}

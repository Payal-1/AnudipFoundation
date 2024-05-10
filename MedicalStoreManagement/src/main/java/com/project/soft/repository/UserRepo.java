package com.project.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.soft.entity.User;


public interface UserRepo extends JpaRepository<User, Long>{
	public User findByUserName(String userName);

}

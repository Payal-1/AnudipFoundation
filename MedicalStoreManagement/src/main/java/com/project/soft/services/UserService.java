package com.project.soft.services;

import java.util.List;

import com.project.soft.entity.User;


public interface UserService {
	
	public User createUser(com.project.soft.entity.User user);
	
	public User getUserById(long userId);
	
	public User getUserByUserName(String userName);
	
	public List<User> getAllUser();
	
	public User updateUser(User user ,long userId);
	
	public void deleteUser(long userId);

}

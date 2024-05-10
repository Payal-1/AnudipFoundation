package com.project.soft.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.entity.User;
import com.project.soft.exception.UserException;
import com.project.soft.repository.UserRepo;
import com.project.soft.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		User presentUser = this.userRepo.findByUserName(user.getUserName());
		
		if(presentUser!=null) {
			System.out.println("user with this UserName is alredy present");
			throw new UserException("user with this UserName "+user.getUserName()+" is alredy present");
		}else {
			
			presentUser = this.userRepo.save(user);
		}
		
		return presentUser ;
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return this.userRepo.findById(userId).orElseThrow(()-> new UserException("User with id "+userId+" is not present"));
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		
		User presentUser = this.userRepo.findByUserName(userName);
		
		if(presentUser != null) {
			return presentUser;
		}else {
		throw new UserException("user With "+userName+" username is not present");
		}
		
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	@Override
	public User updateUser(User user, long userId) {
		User updateUser = this.userRepo.findById(userId).orElseThrow(()-> new UserException("User with id "+userId+" is not present"));;
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setEmail(user.getEmail());
		updateUser.setPhone(user.getPhone());
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setProfile(user.getProfile());
		
		return this.userRepo.save(updateUser);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		User deleteUser = this.userRepo.findById(userId).orElseThrow(()-> new UserException("User with id "+userId+" is not present"));
		this.userRepo.delete(deleteUser);
	}

}

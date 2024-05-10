package com.project.soft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.soft.entity.User;
import com.project.soft.services.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		user.setProfile("default.jpg");
		System.out.println(user);
		
		
		
		return new ResponseEntity<User>(this.userService.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{uId}")
	public ResponseEntity<User> getUserById(@PathVariable long uId){
		
		return new ResponseEntity<User>(this.userService.getUserById(uId),HttpStatus.OK);
	}
	
	
	@GetMapping("/userName/{userName}")
	public ResponseEntity<User> getUserByuserName(@PathVariable String userName){
		
		return new ResponseEntity<User>(this.userService.getUserByUserName(userName),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(this.userService.getAllUser(),HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{uId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long uId){
		return new  ResponseEntity<User>(this.userService.updateUser(user, uId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{uId}")
	
	public ResponseEntity<String> deleteUser(@PathVariable long uId){
		this.userService.deleteUser(uId);
		return new  ResponseEntity<String>("User delete Succefully",HttpStatus.OK);
	}

}

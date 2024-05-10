package com.project.soft.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.entity.Login;
import com.project.soft.repository.LoginRepository;
import com.project.soft.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository lrepo;
	
	@Override
	public Login loginUser(String userName, String password) {

		Login login = lrepo.findByUserNameAndPassword(userName, password);		
		return login;
	}

}

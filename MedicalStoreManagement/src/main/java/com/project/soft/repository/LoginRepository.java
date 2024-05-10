
  package com.project.soft.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;

import com.project.soft.entity.Login;
  
  
  public interface LoginRepository extends JpaRepository<Login, Integer> {
  
	  public Login findByUserNameAndPassword(String userName, String password);
	  
  }
 
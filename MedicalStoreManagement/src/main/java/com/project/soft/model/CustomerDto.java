package com.project.soft.model;

import java.util.List;

import com.project.soft.entity.Billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@AllArgsConstructor
public class CustomerDto {


	  private int id;
	  
	  private String name; 
	  private String contactNumber; 
	  private String email;
	  
	  private List<Billing> billings;

	
	  }
	 

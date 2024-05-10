package com.project.soft.model;

import java.util.List;

import com.project.soft.entity.Drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data 
@AllArgsConstructor
@NoArgsConstructor



public class SupplierDto {
	
	private int id;
	  
	  private String name;
	  private String contactNumber; 
	  private String address;
	  

	
	  private List<Drug> drugsSupplied;


}

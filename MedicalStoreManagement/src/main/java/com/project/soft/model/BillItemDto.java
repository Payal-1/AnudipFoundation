package com.project.soft.model;



import com.project.soft.entity.Billing;
import com.project.soft.entity.Drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class BillItemDto {
	
	
	 private int id;
	  
	  private int quantity; 
	  private double itemTotal;
	 
	  private Drug drug;
	  private Billing billing;

}

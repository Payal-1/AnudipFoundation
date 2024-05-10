package com.project.soft.model;

import java.time.LocalDateTime;
import java.util.List;

import com.project.soft.entity.BillItem;
import com.project.soft.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor

@AllArgsConstructor
public class BillingDto {

	
	 private int bid;
	  
	  private LocalDateTime billingDateTime;
	    
	  private double totalAmount;
	  private Customer customer;
	  private List<BillItem> billItems;
	  
	
}

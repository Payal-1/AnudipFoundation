package com.project.soft.model;

import java.time.LocalDate;
import java.util.List;

import com.project.soft.entity.BillItem;
import com.project.soft.entity.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data 
@AllArgsConstructor
@NoArgsConstructor


public class DrugDto {

	  
	    private int id;

	    private String name;
	    private String description;
	    private int quantity;
	    private double price;
	    private LocalDate expirationDate;
	    
	    private List<BillItem> billItems;

	    private Supplier supplier;

	    
}	
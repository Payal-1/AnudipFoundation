package com.project.soft.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Drug //medicines
{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String description;
	    private int quantity;
	    private double price;
	    private LocalDate expirationDate;
		

	    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
	    @JsonManagedReference("drugReference")
	    private List<BillItem> billItems;


	    @ManyToOne
	    @JsonBackReference("supplierReference")
	    @JoinColumn(name = "supplier_id")
	    private Supplier supplier;


}



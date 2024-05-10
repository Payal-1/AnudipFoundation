
  package com.project.soft.entity;
  
  import java.time.LocalDateTime;
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
  @NoArgsConstructor
  @AllArgsConstructor
  
  @Entity 
  public class Billing {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int bid;
  
  private LocalDateTime billingDateTime;
    
  private double totalAmount;
  
  @ManyToOne
  @JoinColumn(name = "customer_id")
  @JsonBackReference("customerReference")
  private Customer customer;
  

  @OneToMany(mappedBy = "billing")
  @JsonManagedReference("billingReference")
  private List<BillItem> billItems;
  
  
  
  }
 
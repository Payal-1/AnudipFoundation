
  package com.project.soft.entity;
  
  import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType; 
  import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor; import lombok.Data; import
  lombok.NoArgsConstructor;
  
  
  @Data
  
  @AllArgsConstructor
  
  @NoArgsConstructor
  
  
  @Entity 
  public class BillItem {
  
  @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id;
  
  private int quantity; 
  private double itemTotal;
 

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "drug_id")
  @JsonBackReference("drugReference")
  private Drug drug;
  
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "billing_id")
  @JsonBackReference("billingReference")
  private Billing billing;
  
  
  }
  
 
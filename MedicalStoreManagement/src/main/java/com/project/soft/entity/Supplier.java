
  package com.project.soft.entity;
  
  import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity; 
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType; 
  import jakarta.persistence.Id;
  import jakarta.persistence.OneToMany;
  import lombok.AllArgsConstructor; 
  import lombok.Data; 
  import lombok.NoArgsConstructor;
  
  
  @Data
  
  @NoArgsConstructor
  
  @AllArgsConstructor
  
  @Entity public class Supplier {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id;
  
  private String name;
  private String contactNumber; 
  private String address;
  

  @OneToMany(mappedBy = "supplier")
  @JsonManagedReference("supplierReference")
  private List<Drug> drugsSupplied;


  
  
  }
 
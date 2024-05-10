
  package com.project.soft.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.stereotype.Repository;
  
  import com.project.soft.entity.Supplier;
  
  @Repository 
  public interface SupplierRepository extends JpaRepository<Supplier, Integer> 
  
  {
	  // Additional custom queries can be added
  } 
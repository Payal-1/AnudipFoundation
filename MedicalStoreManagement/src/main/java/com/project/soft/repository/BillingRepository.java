
  package com.project.soft.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.project.soft.entity.Billing;
  
  @Repository 
  public interface BillingRepository extends JpaRepository<Billing,Integer> 
  {
	  
  }
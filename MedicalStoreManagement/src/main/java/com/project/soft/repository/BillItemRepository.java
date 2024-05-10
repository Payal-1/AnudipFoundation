
  package com.project.soft.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.project.soft.entity.BillItem;
  
  @Repository public interface BillItemRepository extends JpaRepository<BillItem, Integer>  {
	  
  }
  

  package com.project.soft.Controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import
  org.springframework.web.bind.annotation.*;

import com.project.soft.converter.BillingConverter;

import com.project.soft.model.BillingDto;
import com.project.soft.services.BillingService;
  
  import java.util.List;
  
  @RestController
  @RequestMapping("/billings") 
  public class BillingController {
  
  @Autowired 
  private BillingService bls;
  
  @Autowired
  BillingConverter bConverter;
  
  

  @PostMapping("/addBill")
  public ResponseEntity<BillingDto> createBilling(@RequestBody BillingDto billingDto) {
		return new ResponseEntity<BillingDto>(bls.createBilling(billingDto),HttpStatus.CREATED);
  }  
  
  
  @GetMapping("/allBills") 
  public  ResponseEntity<List<BillingDto>> getAllBillings() 
  { 
	  return new ResponseEntity<List<BillingDto>>(bls.getAllBillings(),HttpStatus.OK);
  }
  
  
  @GetMapping("getBill/{id}") 
  public ResponseEntity<BillingDto> getBillingById(@PathVariable int id)
  {
		return new ResponseEntity<BillingDto>(bls.getBillingById(id),HttpStatus.OK);
  }  
  
  @PutMapping("/updateBill/{id}")
  public ResponseEntity<BillingDto> updateBilling(@RequestBody BillingDto billingDto,@PathVariable int id) {
		return new ResponseEntity<BillingDto>(bls.updateBilling(id, billingDto),HttpStatus.OK);
  }

  
  @DeleteMapping("deleteBill/{id}") 
  public ResponseEntity<String> deleteBilling(@PathVariable int id)
  {
	   bls.deleteBilling(id);
		return new ResponseEntity<String>(" Bill Deleted Successfully!!",HttpStatus.OK);
  }
  }
  
  // Other endpoints or mappings as per requirements }
 
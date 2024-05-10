
 package com.project.soft.Controller;
  
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.soft.converter.CustomerConverter;
import com.project.soft.model.CustomerDto;

import com.project.soft.services.CustomerService;
  
  import java.util.List;
  
  @RestController 
  @RequestMapping("/customers") 
  @CrossOrigin("*")
  public class CustomerController {
  
  @Autowired 
  private CustomerService cs;
  
   @Autowired
   CustomerConverter cConverter;
  
  

  @PostMapping("/addCustomer")
  public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) 
  {
		return new ResponseEntity<CustomerDto>(cs.createCustomer(customerDto),HttpStatus.CREATED);
 

  
  }
  
  
  
  @GetMapping("/allCustomer")
  public ResponseEntity<List<CustomerDto>> getAllCustomers() 
  { 
		return new ResponseEntity<List<CustomerDto>>(cs.getAllCustomers(),HttpStatus.OK);
  }
  
  
  @GetMapping("/getCustomer/{id}") 
  public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int id) {
		return new ResponseEntity<CustomerDto>(cs.getCustomerById(id),HttpStatus.OK);
  }  
  
  
  
  @PutMapping("/updateCustomer/{id}")
  public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable int id)
  {
  System.out.println("");
	  return new ResponseEntity<CustomerDto>(cs.updateCustomer(id, customerDto),HttpStatus.OK);
  }

  
  
  @DeleteMapping("deleteCustomer/{id}") 
  public void deleteCustomer(@PathVariable int id) {
	  
		System.out.println("inside controller"+id);

	  cs.deleteCustomer(id); 

  
  }
  
  } 
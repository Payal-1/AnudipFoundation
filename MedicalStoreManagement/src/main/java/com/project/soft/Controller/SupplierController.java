
  package com.project.soft.Controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.soft.converter.SupplierConverter;
import com.project.soft.model.SupplierDto;
import com.project.soft.services.SupplierService;
  
  import java.util.List;
  
  @RestController
  
  @RequestMapping("/suppliers") 
  @CrossOrigin("*")
  public class SupplierController {
  
  @Autowired 
  private SupplierService ss;
  
  @Autowired
  SupplierConverter sConverter;
  
  
  @PostMapping ("/addSupplier")
  public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto) {
		

  	System.out.println("Data Adeed"+supplierDto);
	  return new ResponseEntity<SupplierDto>(ss.createSupplier(supplierDto),HttpStatus.CREATED);
  }	  
  
  @GetMapping("/allSuppliers") 
  public ResponseEntity<List<SupplierDto>> getAllSuppliers() 
  { 
	  return new ResponseEntity<List<SupplierDto>>(ss.getAllSuppliers(),HttpStatus.OK);
	  }
  
  @GetMapping("getSupplier/{id}") 
  public ResponseEntity<SupplierDto> getSupplierById(@PathVariable int id) {
		return new ResponseEntity<SupplierDto>(ss.getSupplierById(id),HttpStatus.OK);
  }  
  

  @PutMapping("/updateSupplier/{id}")
  public ResponseEntity<SupplierDto> updateSupplier(@RequestBody SupplierDto supplierDto,@PathVariable int id)
  {
  
	  return new ResponseEntity<SupplierDto>(ss.updateSupplier(id, supplierDto),HttpStatus.OK);
  }
  
  @DeleteMapping("deleteSupplier/{id}") 
  public void deleteSupplier(@PathVariable int id) {
	  ss.deleteSupplier(id); 

  }
  }

package com.project.soft.Controller;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.soft.converter.BillItemConverter;
import com.project.soft.model.BillItemDto;
import com.project.soft.services.BillItemService;
  
  import java.util.List;
  
  @RestController
  @RequestMapping("/billitems") 
  public class BillItemController {
  
  @Autowired 
  private BillItemService bs;
  
  
 @Autowired
  BillItemConverter bConverter;
  

  @PostMapping("/addBillItem") 
  public  ResponseEntity<BillItemDto>createBillItem(@RequestBody BillItemDto billItemDto)
  {
	  
  	System.out.println("Data Adeed"+billItemDto);

		return new ResponseEntity<BillItemDto>(bs.createBillItem(billItemDto),HttpStatus.CREATED);
  }
  
  @GetMapping("allItem")
  public ResponseEntity<List<BillItemDto>> getAllBillItems() { 
	  return new ResponseEntity<List<BillItemDto>>(bs.getAllBillItems(),HttpStatus.OK);
  }  
  @GetMapping("getBillItem/{id}") 
   public  ResponseEntity<BillItemDto>getBillItemById(@PathVariable int id)
  {
		return new ResponseEntity<BillItemDto>(bs.getBillItemById(id),HttpStatus.OK);
  }
  
 
  
  @PutMapping("/updateBillItem/{id}")
  public ResponseEntity<BillItemDto> updateBillItem(@RequestBody BillItemDto billItemDto,@PathVariable int id)
  {
  
	  return new ResponseEntity<BillItemDto>(bs.updateBillItem(id, billItemDto),HttpStatus.OK);
  }
  
  @DeleteMapping("deleteBillItem/{id}") 
  public ResponseEntity<String> deleteBillItem(@PathVariable int id) {
 
	  bs.deleteBillItem(id);
		return new ResponseEntity<String>("Bill Item  has been deleted!!!",HttpStatus.OK);

 }
  
  } 
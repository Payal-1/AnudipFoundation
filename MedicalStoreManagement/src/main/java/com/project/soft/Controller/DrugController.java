package com.project.soft.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.soft.converter.DrugConverter;
import com.project.soft.model.DrugDto;

import com.project.soft.services.DrugService;

import java.util.List;

@RestController
@RequestMapping("/drugs")
@CrossOrigin("*")
public class DrugController {
    
    @Autowired
     DrugService ds;

    @Autowired
    DrugConverter dConverter;
    
 
    
    @PostMapping("/addDrug")
    public ResponseEntity<DrugDto> addDrug(@RequestBody DrugDto drugDto) {
		/*
    	Supplier = SupplierService.getSupplierById(drugDto.getOrphanage().getOrphId());
	    admin.setOrphanage(orphanage);
    	*/
    	
    	System.out.println("Data Adeed"+drugDto);
    	return new ResponseEntity<DrugDto>(ds.addDrug(drugDto),HttpStatus.CREATED);
    }
    
    
    @GetMapping("/allDrugs")
    public ResponseEntity<List<DrugDto>>getAllDrugs() {
		return new ResponseEntity<List<DrugDto>>(ds.getAllDrugs(),HttpStatus.OK);
    }
    
    
    @GetMapping("/getDrug/{id}")
	public ResponseEntity<DrugDto>getDrugById(@PathVariable("id") int id)
	
	{
		return new ResponseEntity<DrugDto>(ds.getDrugById(id),HttpStatus.OK);
	}
	
    @PutMapping("/updateDrug/{id}")
    public ResponseEntity<DrugDto> updateDrug(@RequestBody DrugDto drugDto,@PathVariable int id) {
		return new ResponseEntity<DrugDto>(ds.updateDrug(id, drugDto),HttpStatus.OK);
    }

    
        
    @DeleteMapping("deleteDrug/{id}")
    public void deleteDrug(@PathVariable int id) {
        ds.deleteDrug(id);

    }
    
    
    
    
}

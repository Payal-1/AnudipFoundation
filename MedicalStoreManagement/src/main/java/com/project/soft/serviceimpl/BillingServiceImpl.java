
  package com.project.soft.serviceimpl;
  
  import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.converter.BillingConverter;
import com.project.soft.entity.Billing;

import com.project.soft.exception.BillingNotFoundException;
import com.project.soft.model.BillItemDto;
import com.project.soft.model.BillingDto;
import com.project.soft.repository.BillingRepository;
import com.project.soft.services.BillingService;
  
  @Service
  public class BillingServiceImpl implements BillingService
  {
	  @Autowired
	  BillingRepository bRepo;
  
	  @Autowired
	 BillingConverter bConverter;
		
	  
  @Override
  public List<BillingDto> getAllBillings() 
  { 
	  List<Billing> allBills = this.bRepo.findAll();
		 List<BillingDto> collect = allBills.stream().map((billing)->this.bConverter.convertToBillingDto(billing)).collect(Collectors.toList());
		return collect;
	}
  
  @Override 
  public BillingDto getBillingById(int id)
  {  
	  
		Billing billing=bRepo.findById(id).orElseThrow(()-> new BillingNotFoundException("Bill with ID "+id+" is not found"));
 
		return this.bConverter.convertToBillingDto(billing);
  
  }
  
  @Override 
  public BillingDto createBilling(BillingDto billingDto)
  { 		
	  Billing billing= this.bConverter.convertToBilling(billingDto);
	Billing saveBill = this.bRepo.save(billing);
	return this.bConverter.convertToBillingDto(saveBill);
	  }
  
  @Override 
  public void deleteBilling(int id)
  {
	 bRepo.findById(id).orElseThrow(()-> new BillingNotFoundException("Bill with ID "+id+" is not found"));
		bRepo.deleteById(id);
  }



@Override
public BillingDto updateBilling(int id, BillingDto billingDto) {
	// TODO Auto-generated method stub
	return null;
}



  }
 
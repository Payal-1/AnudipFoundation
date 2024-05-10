
  package com.project.soft.services;
  
  
import com.project.soft.model.BillingDto;

import java.util.List;
  
  
  public interface BillingService {
  
  
  public List<BillingDto> getAllBillings();
  
  public BillingDto getBillingById(int id);
  
  public BillingDto createBilling(BillingDto billingDto);
  
  public void deleteBilling(int id);
	public BillingDto updateBilling(int id, BillingDto billingDto);

 }
 
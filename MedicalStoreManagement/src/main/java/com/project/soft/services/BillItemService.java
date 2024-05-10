
  package com.project.soft.services;
  
  
import com.project.soft.model.BillItemDto;

import java.util.List;
  
  public interface BillItemService {
  
  public List<BillItemDto> getAllBillItems();
  
  public BillItemDto getBillItemById(int id);
  
  public BillItemDto createBillItem(BillItemDto billItem);
  
  public void deleteBillItem(int id);
	public BillItemDto updateBillItem(int id, BillItemDto billItem);
  
  }
 
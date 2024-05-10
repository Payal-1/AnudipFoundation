
  package com.project.soft.services;
  
  
import com.project.soft.model.SupplierDto;

import java.util.List;
  
  public interface SupplierService {
  
  
  
  public List<SupplierDto> getAllSuppliers();
  
  public SupplierDto getSupplierById(int id);
  
  public SupplierDto createSupplier(SupplierDto supplier);
	public SupplierDto updateSupplier(int id, SupplierDto supplier);

  public void deleteSupplier(int id);
  }
 
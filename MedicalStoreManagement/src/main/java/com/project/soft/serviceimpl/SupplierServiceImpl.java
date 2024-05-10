
package com.project.soft.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.converter.SupplierConverter;
import com.project.soft.entity.Customer;
import com.project.soft.entity.Supplier;
import com.project.soft.exception.CustomerNotFoundException;
import com.project.soft.exception.SupplierNotFoundException;
import com.project.soft.model.SupplierDto;
import com.project.soft.repository.SupplierRepository;
import com.project.soft.services.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService {

	
	@Autowired
	SupplierRepository sRepo;
	
	@Autowired
	private SupplierConverter sConverter;
	
	@Override
	public List<SupplierDto> getAllSuppliers() {
		List<Supplier> allSuppliers = this.sRepo.findAll();
		 List<SupplierDto> collect = allSuppliers.stream().map((supplier)->this.sConverter.convertToSupplierDto(supplier)).collect(Collectors.toList());
		return collect;		

	
	
	}

	@Override
	public SupplierDto getSupplierById(int id) {
		Supplier supplier = sRepo.findById(id).orElseThrow(()-> new SupplierNotFoundException("Supplier with ID "+id+" is not found"));
		return this.sConverter.convertToSupplierDto(supplier);
	}
	
	
	
	
	
	@Override
	public SupplierDto createSupplier(SupplierDto supplierDto) {
		Supplier supplier = this.sConverter.convertToSupplier(supplierDto);
		Supplier saveSupplier = this.sRepo.save(supplier);
		return this.sConverter.convertToSupplierDto(saveSupplier);
}
	@Override
	public void deleteSupplier(int id) {
		sRepo.findById(id).orElseThrow(()-> new SupplierNotFoundException("Supplier with ID "+id+" is not found"));
		sRepo.deleteById(id);
		
	}
	@Override
	public SupplierDto updateSupplier(int id, SupplierDto supplierDto) {
		Supplier sup1= sRepo.findById(id).orElseThrow(()-> new SupplierNotFoundException("Supplier with ID "+id+" is not found"));
		sup1.setId(id);
		sup1.setName(supplierDto.getName());
		sup1.setAddress(supplierDto.getAddress());
			
		
		Supplier saveSupplier=sRepo.save(sup1);
			return sConverter.convertToSupplierDto(saveSupplier);
			
	}
  
  }
 
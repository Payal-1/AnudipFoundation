package com.project.soft.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.project.soft.entity.Supplier;
import com.project.soft.model.SupplierDto;

@Component
public class SupplierConverter {

	

	
	//converting Supplier Entity to Supplier DTo
		public SupplierDto convertToSupplierDto(Supplier supplier) {
			SupplierDto supplierDto=new SupplierDto();
		
			if(supplier!=null) {
				BeanUtils.copyProperties(supplier, supplierDto);
			}
			
			return supplierDto;
		}
		
		//converting teacher dto to teacher
		
		public Supplier convertToSupplier(SupplierDto supplierDto) {
			Supplier supplier=new Supplier();
			
			if(supplierDto!=null) {
				BeanUtils.copyProperties(supplierDto, supplier);
			}
			
			return supplier;
		}
}

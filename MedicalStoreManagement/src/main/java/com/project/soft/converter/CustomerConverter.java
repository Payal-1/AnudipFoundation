package com.project.soft.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.project.soft.entity.Customer;
import com.project.soft.model.CustomerDto;

@Component
public class CustomerConverter {

	
	
	
	//converting teacher Entity to teacher DTo
		public CustomerDto convertToCustomerDto(Customer Customer) {
			CustomerDto CustomerDto=new CustomerDto();
		
			if(Customer!=null) {
				BeanUtils.copyProperties(Customer, CustomerDto);
			}
			
			return CustomerDto;
		}
		
		//converting teacher dto to teacher
		
		public Customer convertToCustomer(CustomerDto CustomerDto) {
			Customer Customer=new Customer();
			
			if(CustomerDto!=null) {
				BeanUtils.copyProperties(CustomerDto, Customer);
			}
			
			return Customer;
		}

}

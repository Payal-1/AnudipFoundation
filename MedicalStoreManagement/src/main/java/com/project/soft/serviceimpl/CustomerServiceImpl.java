
package com.project.soft.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.soft.converter.CustomerConverter;
import com.project.soft.entity.Customer;
import com.project.soft.entity.Drug;
import com.project.soft.exception.CustomerNotFoundException;
import com.project.soft.exception.DrugNotFoundException;
import com.project.soft.model.CustomerDto;
import com.project.soft.repository.CustomerRepository;
import com.project.soft.services.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cRepo;

	@Autowired
	CustomerConverter cConverter;
	
	
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> allCustomers = this.cRepo.findAll();
		 List<CustomerDto> collect = allCustomers.stream().map((customer)->this.cConverter.convertToCustomerDto(customer)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public CustomerDto getCustomerById(int id) {
		Customer customer = cRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer with ID "+id+" is not found"));
		return this.cConverter.convertToCustomerDto(customer);
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer= this.cConverter.convertToCustomer(customerDto);
		Customer saveCustomer = this.cRepo.save(customer);
		return this.cConverter.convertToCustomerDto(saveCustomer);
}
	
	
	@Override
	public void deleteCustomer(int id) {
		System.out.println("inside service"+id);
		cRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer with ID "+id+" is not found"));
		cRepo.deleteById(id);
	}

	@Override
	public CustomerDto updateCustomer(int id, CustomerDto updateCustomer) {
	Customer customer1 = cRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer with ID "+id+" is not found"));
	customer1.setId(id);
	customer1.setName(updateCustomer.getName());
	customer1.setContactNumber(updateCustomer.getContactNumber());
	customer1.setEmail(updateCustomer.getEmail());

		Customer saveCustomer=cRepo.save(customer1);
		return cConverter.convertToCustomerDto(saveCustomer);
		
	}

  
  }
 
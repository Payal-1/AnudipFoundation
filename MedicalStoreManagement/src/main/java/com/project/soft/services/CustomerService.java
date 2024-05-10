
  package com.project.soft.services;
  
import com.project.soft.model.CustomerDto;

import java.util.List;
  
  public interface CustomerService {
  
  
  public List<CustomerDto> getAllCustomers();
  
  public CustomerDto getCustomerById(int id);
  public CustomerDto updateCustomer(int id,CustomerDto updateCustomer);
  public CustomerDto createCustomer(CustomerDto customerDto);
  
  public void deleteCustomer(int id);
  }

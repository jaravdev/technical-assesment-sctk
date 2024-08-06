package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.CustomerRepository;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer.SaveCustomerRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;

@Repository
public class CreateCustomerDatabase implements SaveCustomerRepository {

  private final CustomerRepository customerRepository;
  private final CustomerResponseMapper customerResponseMapper;

  public CreateCustomerDatabase(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper) {
    this.customerRepository = customerRepository;
    this.customerResponseMapper = customerResponseMapper;
  }

  @Override
  public Customer saveCustomer(CreateCustomerRequest createCustomerRequest) {
    Customer customer = customerResponseMapper.mapRequestToCustomerEntity(createCustomerRequest);
    customer.setRegisterDate(LocalDateTime.now());
    //agregar try catch?
    return customerRepository.save(customer);
  }
}


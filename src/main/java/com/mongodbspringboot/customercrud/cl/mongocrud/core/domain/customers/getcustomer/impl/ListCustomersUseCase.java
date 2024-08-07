package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.model.CustomerListResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist.GetCustomersRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ListCustomersUseCase {

  private final GetCustomersRepository getCustomersRepository;
  private final CustomerResponseMapper customerResponseMapper;

  public ListCustomersUseCase(GetCustomersRepository getCustomersRepository, CustomerResponseMapper customerResponseMapper) {
    this.getCustomersRepository = getCustomersRepository;
    this.customerResponseMapper = customerResponseMapper;
  }

  public CustomerListResponse listAllCustomers() {
    List<Customer> customers = getCustomersRepository.findAllCustomers();
    List<CustomerResponse> customerResponses = customerResponseMapper.mapCustomerEntityListToCustomerResponseList(customers);
    CustomerListResponse response = new CustomerListResponse();
    response.setCustomers(customerResponses);
    return response;
  }
}

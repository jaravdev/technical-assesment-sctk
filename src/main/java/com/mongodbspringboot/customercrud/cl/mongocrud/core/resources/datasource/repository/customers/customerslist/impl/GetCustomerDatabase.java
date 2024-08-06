package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.CustomerRepository;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist.GetCustomersRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GetCustomerDatabase implements GetCustomersRepository {

  private final CustomerRepository customerRepository;

  public GetCustomerDatabase(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<Customer> findAllCustomers() {
    return customerRepository.findAll();
  }
}

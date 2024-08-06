package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.GetCustomerListDatabaseException;
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
    try {
      return customerRepository.findAll();
    } catch (Exception e) {
      throw new GetCustomerListDatabaseException("Error fetching customers from the database");
    }
  }
}

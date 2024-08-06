package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;

public interface SaveCustomerRepository {
  Customer saveCustomer(CreateCustomerRequest createCustomerRequest);
}


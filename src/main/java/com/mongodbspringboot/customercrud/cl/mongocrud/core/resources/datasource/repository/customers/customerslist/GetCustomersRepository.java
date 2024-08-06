package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import java.util.List;

public interface GetCustomersRepository {
  List<Customer> findAllCustomers();
}

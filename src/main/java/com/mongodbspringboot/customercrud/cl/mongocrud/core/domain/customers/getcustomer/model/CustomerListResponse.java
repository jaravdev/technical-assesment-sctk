package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.model;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import java.util.List;

public class CustomerListResponse {
  private List<CustomerResponse> customers;

  public List<CustomerResponse> getCustomers() {
    return customers;
  }

  public void setCustomers(List<CustomerResponse> customers) {
    this.customers = customers;
  }
}


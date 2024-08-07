package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseMapper {

  public Customer mapRequestToCustomerEntity(CreateCustomerRequest createCustomerRequest) {
    if (createCustomerRequest == null) {
      return null;
    }

    Customer customer = new Customer();
    customer.setName(createCustomerRequest.getName());
    customer.setEmail(createCustomerRequest.getEmail());
    customer.setCountry(createCustomerRequest.getCountry());
    customer.setCities(createCustomerRequest.getCities());
    customer.setNationalNumberId(createCustomerRequest.getNationalNumberId());
    return customer;
  }

  public CustomerResponse mapCustomerEntityToCustomerResponse(Customer customer) {
    if (customer == null) {
      return null;
    }

    return new CustomerResponse.Builder()
        .id(customer.getId())
        .name(customer.getName())
        .email(customer.getEmail())
        .country(customer.getCountry())
        .cities(customer.getCities())
        .registerDate(customer.getRegisterDate())
        .nationalNumberId(customer.getNationalNumberId())
        .build();
  }

  public List<CustomerResponse> mapCustomerEntityListToCustomerResponseList(List<Customer> customers) {
    return customers.stream()
        .map(this::mapCustomerEntityToCustomerResponse)
        .collect(Collectors.toList());
  }
}



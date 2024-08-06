package com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerResponseMock {

  public static CustomerResponse createCustomerResponseMock() {
    return new CustomerResponse.Builder()
        .id("1")
        .name("John Doe")
        .email("john.doe@gmail.com")
        .country("united states")
        .cities(List.of("some city"))
        .registerDate(LocalDateTime.now())
        .nationalNumberId("123-11-1245")
        .build();
  }

  public static CustomerResponse createCustomerFemaleResponseMock() {
    return new CustomerResponse.Builder()
        .id("1")
        .name("Jane Smith")
        .email("john.doe@gmail.com")
        .country("united states")
        .cities(List.of("some city"))
        .registerDate(LocalDateTime.now())
        .nationalNumberId("123-11-1245")
        .build();
  }
}

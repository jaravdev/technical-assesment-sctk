package com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import java.util.List;

public class CreateCustomerRequestMock {

  public static CreateCustomerRequest createCustomerRequestMock() {
    CreateCustomerRequest mock = new CreateCustomerRequest();
    mock.setName("John Doe");
    mock.setEmail("john.doe@gmail.com");
    mock.setNationalNumberId("123-11-1245");
    mock.setCountry("united states");
    mock.setCities(List.of("new york, los angeles"));

    return mock;
  }

  public static CreateCustomerRequest InvalidIdNumbercustomerRequestMock() {
    CreateCustomerRequest mock = new CreateCustomerRequest();
    mock.setName("John Doe");
    mock.setEmail("john.doe@gmail.com");
    mock.setNationalNumberId("invalid-ssn");
    mock.setCountry("united states");
    mock.setCities(List.of("New York, Los Angeles"));

    return mock;
  }
}

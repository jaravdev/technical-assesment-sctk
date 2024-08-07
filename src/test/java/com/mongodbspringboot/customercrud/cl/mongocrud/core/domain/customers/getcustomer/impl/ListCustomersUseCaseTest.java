package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerResponseMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.model.CustomerListResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.customerslist.GetCustomersRepository;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class ListCustomersUseCaseTest {

  private ListCustomersUseCase listCustomersUseCase;

  @Mock
  private GetCustomersRepository getCustomersRepository;

  @Mock
  private CustomerResponseMapper customerResponseMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    listCustomersUseCase = new ListCustomersUseCase(getCustomersRepository, customerResponseMapper);
  }

  @Test
  void listAllCustomers_ShouldReturnCustomerListResponse() {
    // GIVEN
    Customer customer1 = CustomerMock.createValidCustomerMockFromChile();
    Customer customer2 = CustomerMock.createValidCustomerMockFromUsa();
    List<Customer> customers = Arrays.asList(customer1, customer2);

    CustomerResponse response1 = CustomerResponseMock.createCustomerResponseMock();
    CustomerResponse response2 = CustomerResponseMock.createCustomerFemaleResponseMock();
    List<CustomerResponse> customerResponses = Arrays.asList(response1, response2);

    // WHEN
    when(getCustomersRepository.findAllCustomers()).thenReturn(customers);
    when(customerResponseMapper.mapCustomerEntityListToCustomerResponseList(customers)).thenReturn(customerResponses);

    CustomerListResponse customerListResponse = listCustomersUseCase.listAllCustomers();

    // THEN
    assertNotNull(customerListResponse);
    assertEquals(2, customerListResponse.getCustomers().size());
    assertEquals("John Doe", customerListResponse.getCustomers().get(0).getName());
    assertEquals("Jane Smith", customerListResponse.getCustomers().get(1).getName());

    verify(getCustomersRepository).findAllCustomers();
    verify(customerResponseMapper).mapCustomerEntityListToCustomerResponseList(customers);
  }
}
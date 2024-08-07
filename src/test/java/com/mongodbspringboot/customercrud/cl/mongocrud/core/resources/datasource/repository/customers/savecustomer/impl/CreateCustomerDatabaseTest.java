package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.SaveCustomerDatabaseException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CreateCustomerRequestMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.CustomerRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreateCustomerDatabaseTest {

  private CreateCustomerDatabase createCustomerDatabase;

  @Mock
  private CustomerRepository customerRepository;

  @Mock
  private CustomerResponseMapper customerResponseMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    createCustomerDatabase = new CreateCustomerDatabase(customerRepository, customerResponseMapper);
  }

  @Test
  void save_customer_should_return_customer_when_successful() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.createCustomerRequestMock();
    Customer customer = CustomerMock.createValidCustomerMock();

    // WHEN
    when(customerResponseMapper.mapRequestToCustomerEntity(any(CreateCustomerRequest.class))).thenReturn(customer);
    when(customerRepository.save(any(Customer.class))).thenReturn(customer);

    Customer savedCustomer = createCustomerDatabase.saveCustomer(request);

    // THEN
    assertNotNull(savedCustomer);
    assertEquals(customer.getName(), savedCustomer.getName());
    assertEquals(customer.getEmail(), savedCustomer.getEmail());
    assertEquals(customer.getCountry(), savedCustomer.getCountry());
    verify(customerResponseMapper).mapRequestToCustomerEntity(any(CreateCustomerRequest.class));
    verify(customerRepository).save(any(Customer.class));
  }

  @Test
  void save_customer_should_throw_save_customer_database_exception_when_repository_fails() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.createCustomerRequestMock();
    Customer customer = new Customer();

    // WHEN
    when(customerResponseMapper.mapRequestToCustomerEntity(any(CreateCustomerRequest.class))).thenReturn(customer);
    doThrow(new RuntimeException("Database error")).when(customerRepository).save(any(Customer.class));

    // THEN
    assertThrows(SaveCustomerDatabaseException.class, () -> {
      createCustomerDatabase.saveCustomer(request);
    });

    verify(customerResponseMapper).mapRequestToCustomerEntity(any(CreateCustomerRequest.class));
    verify(customerRepository).save(any(Customer.class));
  }
}

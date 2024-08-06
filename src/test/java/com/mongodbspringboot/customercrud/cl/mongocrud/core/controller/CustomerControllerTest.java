package com.mongodbspringboot.customercrud.cl.mongocrud.core.controller;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CreateCustomerRequestMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerResponseMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.impl.CreateCustomerUseCase;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.impl.ListCustomersUseCase;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.model.CustomerListResponse;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CustomerControllerTest {

  private CustomerController customerController;

  @Mock
  private CreateCustomerUseCase createCustomerUseCase;

  @Mock
  private ListCustomersUseCase listCustomersUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    customerController = new CustomerController(createCustomerUseCase, listCustomersUseCase);
  }

  @Test
  void create_customer_should_return_customer_response_ok() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.createCustomerRequestMock();
    CustomerResponse responseMock = CustomerResponseMock.createCustomerResponseMock();

    // WHEN
    when(createCustomerUseCase.createCustomer(any(CreateCustomerRequest.class))).thenReturn(responseMock);

    ResponseEntity<CustomerResponse> response = customerController.createCustomer(request);

    // THEN
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("John Doe", response.getBody().getName());
  }

  @Test
  void get_all_customers_should_return_customer_list_response() {
    // GIVEN
    CustomerListResponse responseMock = new CustomerListResponse();
    responseMock.setCustomers(
        List.of(CustomerResponseMock.createCustomerResponseMock(), CustomerResponseMock.createCustomerResponseMock()));

    // WHEN
    when(listCustomersUseCase.listAllCustomers()).thenReturn(responseMock);

    ResponseEntity<CustomerListResponse> response = customerController.listAllCustomers();

    // THEN
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(2, response.getBody().getCustomers().size());
  }
}

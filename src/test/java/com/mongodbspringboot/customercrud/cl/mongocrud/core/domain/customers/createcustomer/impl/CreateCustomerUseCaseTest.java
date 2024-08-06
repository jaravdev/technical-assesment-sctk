package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.CountryValidationService;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CreateCustomerRequestMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerResponseMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer.SaveCustomerRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class CreateCustomerUseCaseTest {

  private CreateCustomerUseCase createCustomerUseCase;

  @Mock
  private SaveCustomerRepository saveCustomerRepository;

  @Mock
  private CustomerResponseMapper customerResponseMapper;
  @Mock
  private CountryValidationService countryValidationService;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    createCustomerUseCase =
        new CreateCustomerUseCase(saveCustomerRepository, customerResponseMapper, countryValidationService);
  }

  @Test
  void create_customer_should_return_customer_response() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.createCustomerRequestMock();
    Customer customer = CustomerMock.createValidCustomerMock();
    CustomerResponse responseMock = CustomerResponseMock.createCustomerResponseMock();

    // WHEN
    when(saveCustomerRepository.saveCustomer(any(CreateCustomerRequest.class))).thenReturn(customer);
    when(customerResponseMapper.mapCustomerEntityToCustomerResponse(any(Customer.class))).thenReturn(responseMock);

    CustomerResponse response = createCustomerUseCase.createCustomer(request);

    // THEN
    assertNotNull(response);
    assertEquals("John Doe", response.getName());
    verify(countryValidationService).validateCustomer(request.getCountry(), request.getNationalNumberId());
    verify(saveCustomerRepository).saveCustomer(any(CreateCustomerRequest.class));
  }

  @Test
  void create_customer_should_throw_validation_exception_when_invalid_data_input() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.InvalidIdNumbercustomerRequestMock();

    // WHEN
    doThrow(new ValidationException("Invalid SSN")).when(countryValidationService)
        .validateCustomer(anyString(), anyString());

    // THEN
    ValidationException exception = assertThrows(ValidationException.class, () -> {
      createCustomerUseCase.createCustomer(request);
    });

    assertEquals("Invalid SSN", exception.getMessage());
    verify(countryValidationService).validateCustomer(anyString(), anyString());
    verify(saveCustomerRepository, never()).saveCustomer(any(CreateCustomerRequest.class));
  }

}
package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CreateCustomerRequestMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks.CustomerMock;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CustomerResponseMapperTest {

  private final CustomerResponseMapper mapper = new CustomerResponseMapper();

  @Test
  void map_request_to_customer_entity_should_map_fields_correctly() {
    // GIVEN
    CreateCustomerRequest request = CreateCustomerRequestMock.createCustomerRequestMock();

    // WHEN
    Customer customer = mapper.mapRequestToCustomerEntity(request);

    // THEN
    assertNotNull(customer);
    assertEquals("John Doe", customer.getName());
    assertEquals("john.doe@gmail.com", customer.getEmail());
    assertEquals("united states", customer.getCountry());
    assertEquals(List.of("new york, los angeles"), customer.getCities());
    assertEquals("123-11-1245", customer.getNationalNumberId());
  }

  @Test
  void map_request_to_customer_entity_should_return_null_for_null_input() {
    // WHEN
    Customer customer = mapper.mapRequestToCustomerEntity(null);

    // THEN
    assertNull(customer);
  }

  @Test
  void map_customer_entity_to_customer_response_should_map_fields_correctly() {
    // GIVEN
    Customer customer = CustomerMock.createValidCustomerMock();

    // WHEN
    CustomerResponse response = mapper.mapCustomerEntityToCustomerResponse(customer);

    // THEN
    assertNotNull(response);
    assertEquals("1", response.getId());
    assertEquals("John Doe", response.getName());
    assertEquals("john.doe@gmail.com", response.getEmail());
    assertEquals("united states", response.getCountry());
    assertEquals(Arrays.asList("some city"), response.getCities());
    assertEquals(customer.getRegisterDate(), response.getRegisterDate());
    assertEquals("123-11-1245", response.getNationalNumberId());
  }

  @Test
  void map_customer_entity_to_customer_response_should_return_null_for_null_input() {
    // WHEN
    CustomerResponse response = mapper.mapCustomerEntityToCustomerResponse(null);

    // THEN
    assertNull(response);
  }
}

package com.mongodbspringboot.customercrud.cl.mongocrud.core.controller;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.impl.CreateCustomerUseCase;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.impl.ListCustomersUseCase;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.getcustomer.model.CustomerListResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CreateCustomerUseCase createCustomerUseCase;
  private final ListCustomersUseCase listCustomersUseCase;

  public CustomerController(CreateCustomerUseCase createCustomerUseCase, ListCustomersUseCase listCustomersUseCase) {
    this.createCustomerUseCase = createCustomerUseCase;
    this.listCustomersUseCase = listCustomersUseCase;
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
    CustomerResponse response = createCustomerUseCase.createCustomer(createCustomerRequest);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<CustomerListResponse> listAllCustomers() {
    CustomerListResponse customers = listCustomersUseCase.listAllCustomers();
    return ResponseEntity.ok(customers);
  }
}

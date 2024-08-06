package com.mongodbspringboot.customercrud.cl.mongocrud.core.controller.mocks;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;

public class CustomerMock {

  public static Customer createValidCustomerMock() {
    Customer customer = new Customer();
    customer.setId(CustomerResponseMock.createCustomerResponseMock().getId());
    customer.setName(CustomerResponseMock.createCustomerResponseMock().getName());
    customer.setEmail(CustomerResponseMock.createCustomerResponseMock().getEmail());
    customer.setCountry(CustomerResponseMock.createCustomerResponseMock().getCountry());
    customer.setCities(CustomerResponseMock.createCustomerResponseMock().getCities());
    customer.setNationalNumberId(CustomerResponseMock.createCustomerResponseMock().getNationalNumberId());
    customer.setRegisterDate(CustomerResponseMock.createCustomerResponseMock().getRegisterDate());

    return customer;
  }

  public static Customer createValidCustomerMockFromUsa() {
    Customer customer = new Customer();
    customer.setId(CustomerResponseMock.createCustomerResponseMock().getId());
    customer.setName(CustomerResponseMock.createCustomerResponseMock().getName());
    customer.setEmail(CustomerResponseMock.createCustomerResponseMock().getEmail());
    customer.setCountry("united states");
    customer.setCities(CustomerResponseMock.createCustomerResponseMock().getCities());
    customer.setNationalNumberId(CustomerResponseMock.createCustomerResponseMock().getNationalNumberId());
    customer.setRegisterDate(CustomerResponseMock.createCustomerResponseMock().getRegisterDate());

    return customer;
  }

  public static Customer createValidCustomerMockFromChile() {
    Customer customer = new Customer();
    customer.setId(CustomerResponseMock.createCustomerResponseMock().getId());
    customer.setName(CustomerResponseMock.createCustomerResponseMock().getName());
    customer.setEmail(CustomerResponseMock.createCustomerResponseMock().getEmail());
    customer.setCountry("chile");
    customer.setCities(CustomerResponseMock.createCustomerResponseMock().getCities());
    customer.setNationalNumberId(CustomerResponseMock.createCustomerResponseMock().getNationalNumberId());
    customer.setRegisterDate(CustomerResponseMock.createCustomerResponseMock().getRegisterDate());

    return customer;
  }


}

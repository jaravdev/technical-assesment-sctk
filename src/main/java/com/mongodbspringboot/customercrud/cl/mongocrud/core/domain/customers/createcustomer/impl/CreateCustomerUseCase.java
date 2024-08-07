package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.CountryValidationService;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.mapper.CustomerResponseMapper;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CreateCustomerRequest;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model.CustomerResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers.savecustomer.SaveCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {

  private final SaveCustomerRepository saveCustomerRepository;
  private final CustomerResponseMapper customerResponseMapper;
  private final CountryValidationService countryValidationService;

  public CreateCustomerUseCase(SaveCustomerRepository saveCustomerRepository, CustomerResponseMapper customerResponseMapper,
                               CountryValidationService countryValidationService) {
    this.saveCustomerRepository = saveCustomerRepository;
    this.customerResponseMapper = customerResponseMapper;
    this.countryValidationService = countryValidationService;
  }

  public CustomerResponse createCustomer(CreateCustomerRequest customerRequest) {
    countryValidationService.validateCustomerByCountry(customerRequest.getCountry(),
        customerRequest.getNationalNumberId(), customerRequest.getCities());

    return customerResponseMapper.mapCustomerEntityToCustomerResponse(saveCustomerRepository.saveCustomer(customerRequest));
  }
}

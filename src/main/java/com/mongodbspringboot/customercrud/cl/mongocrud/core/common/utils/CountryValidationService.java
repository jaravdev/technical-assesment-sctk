package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class CountryValidationService {

  private final ChileanRutValidationService chileanRutValidationService;
  private final USASocialSecurityValidationService usaSocialSecurityValidationService;

  public CountryValidationService(
      ChileanRutValidationService chileanRutValidationService,
      USASocialSecurityValidationService usaSocialSecurityValidationService) {
    this.chileanRutValidationService = chileanRutValidationService;
    this.usaSocialSecurityValidationService = usaSocialSecurityValidationService;
  }

  public void validateCustomer(String country, String nationalNumberId) {
    switch (country.toLowerCase()) {
      case "chile":
        chileanRutValidationService.validate(nationalNumberId);
        break;
      case "united states":
      case "usa":
        usaSocialSecurityValidationService.validate(nationalNumberId);
        break;
      default:
        throw new ValidationException("Country validation not supported: " + country);
    }
  }
}

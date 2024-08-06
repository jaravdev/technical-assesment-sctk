package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.impl.ChileanRutValidationServiceChilean;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa.impl.USASocialSecurityValidationServiceChilean;
import org.springframework.stereotype.Service;

@Service
public class CountryValidationService {

  private final ChileanRutValidationServiceChilean chileanRutValidationService;
  private final USASocialSecurityValidationServiceChilean usaSocialSecurityValidationService;

  public CountryValidationService(
      ChileanRutValidationServiceChilean chileanRutValidationService,
      USASocialSecurityValidationServiceChilean usaSocialSecurityValidationService) {
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

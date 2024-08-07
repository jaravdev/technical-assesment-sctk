package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.NationalChileanIdValidationService;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa.NationalUsaIdValidationService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryValidationService {

  private final NationalChileanIdValidationService chileanValidationService;
  private final NationalUsaIdValidationService usaValidationService;

  public CountryValidationService(
      NationalChileanIdValidationService chileanValidationService,
      NationalUsaIdValidationService usaValidationService) {
    this.chileanValidationService = chileanValidationService;
    this.usaValidationService = usaValidationService;
  }

  public void validateCustomerByCountry(String country, String nationalNumberId, List<String> regions) {
    switch (country.toLowerCase()) {
      case "chile":
        chileanValidationService.validate(nationalNumberId);
        chileanValidationService.validateRegions(regions);
        break;
      case "united states":
      case "usa":
        usaValidationService.validate(nationalNumberId);
        usaValidationService.validateRegions(regions);
        break;
      default:
        throw new ValidationException("Country validation not supported: " + country);
    }
  }
}

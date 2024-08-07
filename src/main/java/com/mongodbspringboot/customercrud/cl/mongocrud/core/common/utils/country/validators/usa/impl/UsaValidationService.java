package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.InvalidUsaStateException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.enums.UsaRegionEnum;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa.NationalUsaIdValidationService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsaValidationService implements NationalUsaIdValidationService {

  @Override
  public void validate(String nationalNumberId) {
    if (!isValidSSNFormat(nationalNumberId)) {
      throw new InvalidUsaStateException("Invalid US Social Security Number format.");
    }
  }

  @Override
  public void validateRegions(List<String> regions) {
    for (String region : regions) {
      if (UsaRegionEnum.fromState(region) == null) {
        throw new InvalidUsaStateException("Invalid USA state: " + region);
      }
    }
  }

  private boolean isValidSSNFormat(String ssn) {
    return ssn.matches("^(?!000|666)[0-9]{3}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");
  }
}

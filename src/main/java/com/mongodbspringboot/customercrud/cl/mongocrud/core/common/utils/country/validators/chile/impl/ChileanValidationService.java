package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.InvalidChileanRegionException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.enums.ChileanRegionEnum;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.NationalChileanIdValidationService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChileanValidationService implements NationalChileanIdValidationService {

  @Override
  public void validate(String nationalNumberId) {
    if (!isValidRutFormat(nationalNumberId)) {
      throw new InvalidChileanRegionException("Invalid Chilean RUT format.");
    }
  }

  @Override
  public void validateRegions(List<String> regions) {
    for (String region : regions) {
      if (ChileanRegionEnum.fromRegion(region) == null) {
        throw new InvalidChileanRegionException("Invalid Chilean region: " + region);
      }
    }
  }

  private boolean isValidRutFormat(String rut) {
    return rut.matches("^[0-9]+-[0-9kK]$");
  }
}

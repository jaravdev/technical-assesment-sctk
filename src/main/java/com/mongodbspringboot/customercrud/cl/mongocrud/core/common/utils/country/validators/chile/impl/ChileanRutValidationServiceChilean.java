package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.impl;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ChileanRutValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.NationalChileanIdValidationService;
import org.springframework.stereotype.Service;

@Service
public class ChileanRutValidationServiceChilean implements NationalChileanIdValidationService {

  @Override
  public void validate(String rut) {
    if (!isValidRutFormat(rut)) {
      throw new ChileanRutValidationException("Invalid Chilean RUT format.");
    }
  }

  private boolean isValidRutFormat(String rut) {
    return rut.matches("^[0-9]+-[0-9kK]$");
  }
}

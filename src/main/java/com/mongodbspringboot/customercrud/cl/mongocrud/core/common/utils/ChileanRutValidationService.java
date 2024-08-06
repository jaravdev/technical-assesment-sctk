package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ChileanRutValidationException;
import org.springframework.stereotype.Service;

@Service
public class ChileanRutValidationService {

  public void validate(String rut) {
    if (!isValidRutFormat(rut)) {
      throw new ChileanRutValidationException("Invalid Chilean RUT format.");
    }
  }

  private boolean isValidRutFormat(String rut) {
    return rut.matches("^[0-9]+-[0-9kK]$");
  }
}

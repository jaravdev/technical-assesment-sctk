package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.SocialSecurityNumberValidationException;
import org.springframework.stereotype.Service;

@Service
public class USASocialSecurityValidationService {

  public void validate(String ssn) {
    if (!isValidSSNFormat(ssn)) {
      throw new SocialSecurityNumberValidationException("Invalid US Social Security Number format.");
    }
  }

  private boolean isValidSSNFormat(String ssn) {
    return ssn.matches("^(?!000|666)[0-9]{3}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");
  }
}

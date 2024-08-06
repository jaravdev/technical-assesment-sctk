package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions;

public class SocialSecurityNumberValidationException extends RuntimeException {

  public SocialSecurityNumberValidationException(String message) {
    super(message);
  }
}
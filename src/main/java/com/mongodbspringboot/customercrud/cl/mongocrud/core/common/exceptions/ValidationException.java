package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions;

public class ValidationException extends RuntimeException {

  public ValidationException(String message) {
    super(message);
  }
}

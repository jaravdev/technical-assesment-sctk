package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions;

public class SaveCustomerDatabaseException extends RuntimeException {

  public SaveCustomerDatabaseException(String message) {
    super(message);
  }
}
package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions;

public class GetCustomerListDatabaseException extends RuntimeException {

  public GetCustomerListDatabaseException(String message) {
    super(message);
  }
}
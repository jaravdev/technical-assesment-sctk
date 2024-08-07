package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions;

public class InvalidUsaStateException extends RuntimeException {

  public InvalidUsaStateException(String message) {
    super(message);
  }
}
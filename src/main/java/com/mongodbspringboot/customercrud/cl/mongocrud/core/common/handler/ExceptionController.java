package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.handler;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ChileanRutValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ErrorResponse;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.SocialSecurityNumberValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationInputFieldsExceptions(MethodArgumentNotValidException ex) {
    List<String> details = ex.getBindingResult().getAllErrors().stream()
        .map(error -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          return fieldName + ": " + errorMessage;
        })
        .collect(Collectors.toList());
    ErrorResponse error = new ErrorResponse("Validation Failed", details);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<String> handleValidationException(ValidationException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SocialSecurityNumberValidationException.class)
  public ResponseEntity<String> handleValidationSocialNumberUsaException(SocialSecurityNumberValidationException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(ChileanRutValidationException.class)
  public ResponseEntity<String> handleChileanValidationSocialNumberUsaException(ChileanRutValidationException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}

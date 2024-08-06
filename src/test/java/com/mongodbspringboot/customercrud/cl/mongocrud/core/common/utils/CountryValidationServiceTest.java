package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

class CountryValidationServiceTest {

  private CountryValidationService countryValidationService;

  @Mock
  private ChileanRutValidationService chileanRutValidationService;

  @Mock
  private USASocialSecurityValidationService usaSocialSecurityValidationService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    countryValidationService = new CountryValidationService(
        chileanRutValidationService,
        usaSocialSecurityValidationService
    );
  }

  @Test
  void validateCustomer_ShouldCallChileanRutValidationService_WhenCountryIsChile() {
    // WHEN
    countryValidationService.validateCustomer("chile", "12345678-9");

    // THEN
    verify(chileanRutValidationService).validate("12345678-9");
  }

  @Test
  void validateCustomer_ShouldCallUSASocialSecurityValidationService_WhenCountryIsUSA() {
    // WHEN
    countryValidationService.validateCustomer("usa", "123-45-6789");

    // THEN
    verify(usaSocialSecurityValidationService).validate("123-45-6789");
  }

  @Test
  void validateCustomer_ShouldThrowValidationException_WhenCountryNotSupported() {
    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomer("unsupported country", "some-id")
    );
  }

  @Test
  void validateCustomer_ShouldThrowValidationException_WhenChileanRutIsInvalid() {
    // GIVEN
    doThrow(new ValidationException("Invalid Chilean RUT format."))
        .when(chileanRutValidationService)
        .validate("invalid-rut");

    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomer("chile", "invalid-rut")
    );
  }

  @Test
  void validateCustomer_ShouldThrowValidationException_WhenUSASSNIsInvalid() {
    // GIVEN
    doThrow(new ValidationException("Invalid US Social Security Number format."))
        .when(usaSocialSecurityValidationService)
        .validate("invalid-ssn");

    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomer("usa", "invalid-ssn")
    );
  }
}

package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.InvalidChileanRegionException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.InvalidUsaStateException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.exceptions.ValidationException;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.CountryValidationService;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile.NationalChileanIdValidationService;
import com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa.NationalUsaIdValidationService;
import java.util.List;
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
  private NationalChileanIdValidationService chileanValidationService;

  @Mock
  private NationalUsaIdValidationService usaValidationService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    countryValidationService = new CountryValidationService(chileanValidationService, usaValidationService);
  }

  @Test
  void validate_customer_should_call_chilean_validation_service_when_country_is_chile() {
    // WHEN
    countryValidationService.validateCustomerByCountry("chile", "12345678-9", List.of("RM"));

    // THEN
    verify(chileanValidationService).validate("12345678-9");
    verify(chileanValidationService).validateRegions(List.of("RM"));
  }

  @Test
  void validate_customer_should_call_usa_validation_service_when_country_is_USA() {
    // WHEN
    countryValidationService.validateCustomerByCountry("usa", "123-45-6789", List.of("CA"));

    // THEN
    verify(usaValidationService).validate("123-45-6789");
    verify(usaValidationService).validateRegions(List.of("CA"));
  }

  @Test
  void validate_customer_should_throw_validation_exception_when_country_not_supported() {
    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomerByCountry("unsupported country", "some-id", List.of("region"))
    );
  }

  @Test
  void validate_customer_should_throw_validation_exception_when_chilean_rut_is_invalid() {
    // GIVEN
    doThrow(new ValidationException("Invalid Chilean RUT format."))
        .when(chileanValidationService)
        .validate("invalid-rut");

    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomerByCountry("chile", "invalid-rut", List.of("RM"))
    );
  }

  @Test
  void validate_customer_should_throw_validation_exception_when_USA_SSN_is_Invalid() {
    // GIVEN
    doThrow(new ValidationException("Invalid US Social Security Number format."))
        .when(usaValidationService)
        .validate("invalid-ssn");

    // WHEN & THEN
    assertThrows(ValidationException.class, () ->
        countryValidationService.validateCustomerByCountry("usa", "invalid-ssn", List.of("CA"))
    );
  }

  @Test
  void validate_customer_should_throw_invalid_chilean_region_exception_when_region_is_invalid() {
    // GIVEN
    doThrow(new InvalidChileanRegionException("Invalid Chilean region: InvalidRegion"))
        .when(chileanValidationService)
        .validateRegions(List.of("InvalidRegion"));

    // WHEN & THEN
    assertThrows(InvalidChileanRegionException.class, () ->
        countryValidationService.validateCustomerByCountry("chile", "12345678-9", List.of("InvalidRegion"))
    );
  }

  @Test
  void validate_customer_should_throw_invalid_Usa_state_exception_when_state_is_invalid() {
    // GIVEN
    doThrow(new InvalidUsaStateException("Invalid USA state: InvalidState"))
        .when(usaValidationService)
        .validateRegions(List.of("InvalidState"));

    // WHEN & THEN
    assertThrows(InvalidUsaStateException.class, () ->
        countryValidationService.validateCustomerByCountry("usa", "123-45-6789", List.of("InvalidState"))
    );
  }
}

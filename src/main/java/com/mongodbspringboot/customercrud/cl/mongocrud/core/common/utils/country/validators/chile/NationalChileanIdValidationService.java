package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.chile;

import java.util.List;
public interface NationalChileanIdValidationService {
  void validate(String nationalNumberId);
  void validateRegions(List<String> regions);
}


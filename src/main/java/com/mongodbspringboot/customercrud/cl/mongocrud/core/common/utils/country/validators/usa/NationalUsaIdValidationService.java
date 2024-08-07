package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.validators.usa;

import java.util.List;
public interface NationalUsaIdValidationService {
  void validate(String nationalNumberId);
  void validateRegions(List<String> regions);
}

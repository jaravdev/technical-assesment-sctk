package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;


public class CreateCustomerRequest {

  @NotNull
  @NotEmpty(message = "Name cannot be empty")
  private String name;

  @Email(message = "Invalid email format")
  @NotNull(message = "Email cannot be null")
  @NotEmpty(message = "Email cannot be empty")
  private String email;

  @NotNull(message = "Country cannot be null")
  @NotEmpty(message = "Country cannot be empty")
  private String country;

  @NotNull(message = "Cities cannot be null")
  @NotEmpty(message = "Cities cannot be empty")
  private List<String> cities;

  @NotNull(message = "National number ID cannot be null")
  @NotEmpty(message = "National number ID cannot be empty")
  private String nationalNumberId;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public List<String> getCities() {
    return cities;
  }

  public void setCities(List<String> cities) {
    this.cities = cities;
  }

  public String getNationalNumberId() {
    return nationalNumberId;
  }

  public void setNationalNumberId(String nationalNumberId) {
    this.nationalNumberId = nationalNumberId;
  }
}

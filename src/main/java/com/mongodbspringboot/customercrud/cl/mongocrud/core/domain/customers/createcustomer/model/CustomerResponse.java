package com.mongodbspringboot.customercrud.cl.mongocrud.core.domain.customers.createcustomer.model;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerResponse {

  private final String id;
  private final String name;
  private final String email;
  private final String country;
  private final List<String> cities;
  private final LocalDateTime registerDate;
  private final String nationalNumberId;

  private CustomerResponse(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.email = builder.email;
    this.country = builder.country;
    this.cities = builder.cities;
    this.registerDate = builder.registerDate;
    this.nationalNumberId = builder.nationalNumberId;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getCountry() {
    return country;
  }

  public List<String> getCities() {
    return cities;
  }

  public LocalDateTime getRegisterDate() {
    return registerDate;
  }

  public String getNationalNumberId() {
    return nationalNumberId;
  }

  public static class Builder {
    private String id;
    private String name;
    private String email;
    private String country;
    private List<String> cities;
    private LocalDateTime registerDate;
    private String nationalNumberId;

    public Builder() {
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder cities(List<String> cities) {
      this.cities = cities;
      return this;
    }

    public Builder registerDate(LocalDateTime registerDate) {
      this.registerDate = registerDate;
      return this;
    }

    public Builder nationalNumberId(String nationalNumberId) {
      this.nationalNumberId = nationalNumberId;
      return this;
    }

    public CustomerResponse build() {
      return new CustomerResponse(this);
    }
  }
}

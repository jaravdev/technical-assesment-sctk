package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

  @Id
  private String id;

  @NotNull
  private String name;

  @Email
  @NotNull
  private String email;

  @NotNull
  private String country;

  private List<String> cities;

  private LocalDateTime registerDate;

  @NotNull
  private String nationalNumberId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public LocalDateTime getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(LocalDateTime registerDate) {
    this.registerDate = registerDate;
  }

  public String getNationalNumberId() {
    return nationalNumberId;
  }

  public void setNationalNumberId(String nationalNumberId) {
    this.nationalNumberId = nationalNumberId;
  }
}


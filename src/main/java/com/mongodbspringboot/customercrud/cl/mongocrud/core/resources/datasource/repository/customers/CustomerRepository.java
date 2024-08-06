package com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.repository.customers;

import com.mongodbspringboot.customercrud.cl.mongocrud.core.resources.datasource.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}

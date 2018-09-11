package com.bookingsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookingsystem.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

package com.prospera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospera.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
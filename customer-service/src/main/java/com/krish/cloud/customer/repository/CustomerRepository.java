package com.krish.cloud.customer.repository;

import com.krish.cloud.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);   // ✅ ADD THIS
}
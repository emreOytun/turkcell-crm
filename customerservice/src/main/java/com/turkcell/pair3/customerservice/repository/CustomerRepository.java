package com.turkcell.pair3.customerservice.repository;

import com.turkcell.pair3.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

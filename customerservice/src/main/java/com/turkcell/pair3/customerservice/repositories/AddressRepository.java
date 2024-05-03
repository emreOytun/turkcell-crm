package com.turkcell.pair3.customerservice.repositories;

import com.turkcell.pair3.customerservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByCustomerId(Integer customerId);
}

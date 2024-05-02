package com.turkcell.pair3.customerservice.repositories;

import com.turkcell.pair3.customerservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT ad FROM Address ad JOIN ad.customer c WHERE ad.id = :addressId and ad.isPrimary=TRUE ")
    Address findPrimaryAddressByAddressId(Integer addressId);
}

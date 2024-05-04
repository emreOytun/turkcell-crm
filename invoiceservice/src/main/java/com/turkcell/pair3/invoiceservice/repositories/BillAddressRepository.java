package com.turkcell.pair3.invoiceservice.repositories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.entities.BillAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillAddressRepository extends JpaRepository<BillAddress, Integer> {
}

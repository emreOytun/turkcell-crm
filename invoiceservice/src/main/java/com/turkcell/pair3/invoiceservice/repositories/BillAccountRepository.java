package com.turkcell.pair3.invoiceservice.repositories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillAccountRepository extends JpaRepository<BillAccount, Integer>{

}

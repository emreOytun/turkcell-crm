package com.turkcell.pair3.invoiceservice.repositories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillAccountRepository extends JpaRepository<BillAccount, Integer>{

    List<BillAccount> findByCustomerId(Integer customerId);


}

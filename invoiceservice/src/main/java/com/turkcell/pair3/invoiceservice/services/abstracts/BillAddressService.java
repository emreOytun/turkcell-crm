package com.turkcell.pair3.invoiceservice.services.abstracts;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;

public interface BillAddressService {
    void saveBillAddress(Integer addressId, BillAccount billAccountId);
}

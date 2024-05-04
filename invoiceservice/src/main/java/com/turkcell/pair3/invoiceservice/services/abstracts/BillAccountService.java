package com.turkcell.pair3.invoiceservice.services.abstracts;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;

public interface BillAccountService {

    void createBillAccount(AddBillAccountRequest addBillAccountRequest);
    UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest);

    void deleteBillAccount(Integer invoiceId);
    BillAccount getBillAccountById(Integer billAccountId);
}

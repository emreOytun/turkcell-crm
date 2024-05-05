package com.turkcell.pair3.invoiceservice.services.abstracts;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;

import java.util.List;

public interface BillAccountService {

    void createBillAccount(AddBillAccountRequest addBillAccountRequest);
    void deleteBillAccount(Integer invoiceId);
    UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest);
    BillAccount getBillAccountById(Integer billAccountId);
    List<BillAccountResponse> getInvoices(Integer customerId);
    List<Integer> getAllInvoiceIds(Integer customerId);
}

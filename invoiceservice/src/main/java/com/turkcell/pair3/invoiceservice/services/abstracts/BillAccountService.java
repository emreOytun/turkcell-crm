package com.turkcell.pair3.invoiceservice.services.abstracts;

import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;

public interface BillAccountService {

    AddBillAccountResponse createBillAccount(AddBillAccountRequest addBillAccountRequest);
    UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest);


}

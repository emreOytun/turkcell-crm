package com.turkcell.pair3.invoiceservice.services.concretes;

import com.turkcell.pair3.invoiceservice.repositories.BillAccountRepository;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillAccountServiceImpl implements BillAccountService {

    private final BillAccountRepository billAccountRepository;

    @Override
    public AddBillAccountResponse createBillAccount(AddBillAccountRequest addBillAccountRequest) {
        return null;
    }

    @Override
    public UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest) {
        return null;
    }
}

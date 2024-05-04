package com.turkcell.pair3.invoiceservice.services.concretes;

import java.util.ArrayList;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.invoiceservice.clients.CustomerServiceClient;
import com.turkcell.pair3.invoiceservice.clients.ProductServiceClient;
import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.entities.BillAddress;
import com.turkcell.pair3.invoiceservice.repositories.BillAccountRepository;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAddressRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;
import com.turkcell.pair3.invoiceservice.services.mapper.BillAccountMapper;
import com.turkcell.pair3.invoiceservice.services.mapper.BillAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillAccountServiceImpl implements BillAccountService {

    private final BillAccountRepository billAccountRepository;
    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;


    @Override
    public void createBillAccount(AddBillAccountRequest request) {
        BillAccount billAccount = new BillAccount();
        billAccount.setCustomerId(request.getCustomerId());
        billAccount.setAccountName(request.getAccountName());

        if (request.getAddressId() != null) {
            billAccount.setBillAddressList(new ArrayList<>());
            for (Integer addressId : request.getAddressId()) {
                BillAddress billAddress = new BillAddress();
                billAddress.setAddressId(addressId);
                billAddress.setBillAccount(billAccount); // Set the association
                billAccount.getBillAddressList().add(billAddress);
            }
        }
        billAccountRepository.save(billAccount);
    }

    @Override
    public UpdateBillAccountRequest updateBillAccount(UpdateBillAccountRequest updateBillAccountRequest) {
        return null;
    }

    @Override
    public void deleteBillAccount(Integer id) {

        // TODO : remove magic string
        if (!productServiceClient.hasAccountProduct(id)){
            billAccountRepository.deleteById(id);
        }
        else throw new BusinessException("Account has product");


    }
}

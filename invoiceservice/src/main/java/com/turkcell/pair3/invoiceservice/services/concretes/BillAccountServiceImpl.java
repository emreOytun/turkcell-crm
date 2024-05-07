package com.turkcell.pair3.invoiceservice.services.concretes;

import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;
import com.turkcell.pair3.invoiceservice.services.mapper.BillAccountMapper;
import com.turkcell.pair3.messages.Messages;
import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.invoiceservice.clients.ProductServiceClient;
import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import com.turkcell.pair3.invoiceservice.repositories.BillAccountRepository;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAddressService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.UpdateBillAccountRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillAccountServiceImpl implements BillAccountService {

    private final BillAccountRepository billAccountRepository;
    private final ProductServiceClient productServiceClient;
    private final BillAddressService billAddressService;
    private final MessageService messageService;


    @Override
    public void createBillAccount(AddBillAccountRequest request) {
        BillAccount billAccount = new BillAccount();
        billAccount.setCustomerId(request.getCustomerId());
        billAccount.setAccountName(request.getAccountName());

        BillAccount savedAccount = billAccountRepository.save(billAccount);

        if (request.getAddressId() != null) {
            for (Integer addressId : request.getAddressId()) {
                billAddressService.saveBillAddress(addressId, savedAccount);
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

        if (!productServiceClient.hasAccountProduct(id)){
            billAccountRepository.deleteById(id);
        }
        else throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_HAS_PRODUCT));
    }

    @Override
    public BillAccount getBillAccountById(Integer billAccountId) {
        return billAccountRepository.findById(billAccountId).orElseThrow(()
                -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_NOT_FOUND)));
    }

    @Override
    public List<BillAccountResponse> getInvoices(Integer customerId) {
        List<BillAccount> billAccounts = billAccountRepository.findByCustomerId(customerId);

        if(billAccounts.isEmpty())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NO_BILL_ACCOUNT_FOUND_GIVEN_ID));

        List<BillAccountResponse> billAccountResponsesList = billAccounts.stream()
                .map(BillAccountMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());

        return billAccountResponsesList;
    }

    @Override
    public List<Integer> getAllInvoiceIds(Integer customerId) {
        List<Integer> billAccountIds = billAccountRepository.findIdsByCustomerId(customerId);
        if(billAccountIds.isEmpty())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NO_BILL_ACCOUNT_FOUND_GIVEN_ID));

        return billAccountIds;
    }
}

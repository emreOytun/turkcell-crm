package com.turkcell.pair3.invoiceservice.controllers;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.invoiceservice.clients.CustomerServiceClient;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.BillAccountResponse;
import com.turkcell.pair3.messages.Messages;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class BillAccountController {
    private final BillAccountService billAccountService;
    private final CustomerServiceClient customerServiceClient;
    private final MessageService messageService;

    @PostMapping
    public void create(@RequestBody @Valid AddBillAccountRequest addBillAccountRequest) {
        billAccountService.createBillAccount(addBillAccountRequest);
    }

    // TODO get invoices by customer id
    @GetMapping("/{customerId}")
    public List<BillAccountResponse> getInvoices(@PathVariable Integer customerId) {
        return null;
    }

    // update an invoice
    @PutMapping("/{invoiceId}")
    public void updateInvoice(@PathVariable Integer invoiceId) {
        return;
    }

    @DeleteMapping("/{invoiceId}")
    public void deleteInvoice(@PathVariable Integer invoiceId) {
        billAccountService.deleteBillAccount(invoiceId);
    }

    //test method
    @GetMapping("/test")
    public String test() throws BusinessException {
        throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NO_CUSTOMER_FOUND));
    }

    @GetMapping("/{customerId}/getAllInvoiceIds")
    public List<Integer> getAllInvoiceIds(@PathVariable Integer customerId) {
        return billAccountService.getAllInvoiceIds(customerId);
    }

}

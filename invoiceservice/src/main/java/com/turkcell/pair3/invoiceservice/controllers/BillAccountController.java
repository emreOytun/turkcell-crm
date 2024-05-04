package com.turkcell.pair3.invoiceservice.controllers;

import com.turkcell.pair3.invoiceservice.clients.CustomerServiceClient;
import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class BillAccountController {
    private final BillAccountService billAccountService;
    private final CustomerServiceClient customerServiceClient;

    @PostMapping
    public void create(@RequestBody @Valid AddBillAccountRequest addBillAccountRequest) {
        billAccountService.createBillAccount(addBillAccountRequest);
    }

    // get all invoices of a customer
    @GetMapping("/{customerId}")
    public AddBillAccountResponse getInvoices(@PathVariable Integer customerId) {
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
    public String test() {
        return "test";
    }



}

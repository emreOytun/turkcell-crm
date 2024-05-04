package com.turkcell.pair3.invoiceservice.controllers;

import com.turkcell.pair3.invoiceservice.services.abstracts.BillAccountService;
import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAccountRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.responses.AddBillAccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class BillAccountController {
    private final BillAccountService billAccountService;

    @PostMapping
    public AddBillAccountResponse create(@RequestBody @Valid AddBillAccountRequest addBillAccountRequest) {
        return billAccountService.createBillAccount(addBillAccountRequest);
    }
}

package com.turkcell.pair3.invoiceservice.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBillAccountRequest {
    private int customerId;
    private String accountName;

}

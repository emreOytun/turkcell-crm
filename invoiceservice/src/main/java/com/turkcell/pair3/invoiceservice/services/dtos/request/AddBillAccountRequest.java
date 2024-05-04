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

    //TODO : Validation
    private Integer customerId;

    private String accountName;

    private Integer addressId;

}

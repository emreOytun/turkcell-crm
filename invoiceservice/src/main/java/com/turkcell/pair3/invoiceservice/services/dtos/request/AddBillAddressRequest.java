package com.turkcell.pair3.invoiceservice.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBillAddressRequest {

    private Integer cityId;
    private String street;
    private String houseNumber;
    private String description;
    private Integer customerId;

}

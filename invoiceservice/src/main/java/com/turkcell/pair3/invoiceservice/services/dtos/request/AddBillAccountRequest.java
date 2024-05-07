package com.turkcell.pair3.invoiceservice.services.dtos.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBillAccountRequest {

    @Min(1)
    private Integer customerId;

    private String accountName;

    private List<Integer> addressId;

}

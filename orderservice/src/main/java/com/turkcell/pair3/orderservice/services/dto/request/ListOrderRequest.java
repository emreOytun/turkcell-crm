package com.turkcell.pair3.orderservice.services.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Setter
public class ListOrderRequest {

    private String id;
    private LocalDate orderDate;
    private String customerId;
    private double totalPrice;


}

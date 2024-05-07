package com.turkcell.pair3.orderservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ListOrderResponse {

    private String id;
    private LocalDateTime orderDate;
    private String customerId;
    private double totalPrice;

}
package com.turkcell.pair3.orderservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CreateOrderResponse {

    private LocalDateTime orderDate;
    private String customerId;
    private List<String> products;

}
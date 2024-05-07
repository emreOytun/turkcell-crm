package com.turkcell.pair3.orderservice.services.abstracts;

import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.services.dtos.requests.CreateOrderRequest;
import com.turkcell.pair3.orderservice.services.dtos.responses.CreateOrderResponse;
import com.turkcell.pair3.orderservice.services.dtos.responses.ListOrderResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface OrderService {

    double calculateTotalPrice(CreateOrderRequest request);

    String createOrder(CreateOrderRequest createOrderRequest);

    void deleteOrder(String orderId);

    List<Date> getDatesOfOrdersByBillAccounts(List<Integer> billAccountIdList);
}
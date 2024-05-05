package com.turkcell.pair3.orderservice.services.abstracts;

import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.services.dto.request.CreateOrderRequest;
import com.turkcell.pair3.orderservice.services.dto.response.CreateOrderResponse;
import com.turkcell.pair3.orderservice.services.dto.response.ListOrderResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    double calculateTotalPrice(CreateOrderRequest request);

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    void deleteOrder(String orderId);


}

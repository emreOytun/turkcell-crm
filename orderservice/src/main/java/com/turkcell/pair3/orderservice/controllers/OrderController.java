package com.turkcell.pair3.orderservice.controllers;

import com.turkcell.pair3.orderservice.services.abstracts.OrderService;
import com.turkcell.pair3.orderservice.services.dtos.requests.CreateOrderRequest;
import com.turkcell.pair3.orderservice.services.dtos.responses.CreateOrderResponse;
import com.turkcell.pair3.orderservice.services.dtos.responses.ListOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/getOrderIds")
    List<Date> getDatesOfOrdersByBillAccounts(@RequestParam("values") List<Integer> billAccountIdList) {
        return orderService.getDatesOfOrdersByBillAccounts(billAccountIdList);
    }

}
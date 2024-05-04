package com.turkcell.pair3.orderservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    public int getId() {
        return 10;
    }

//    @GetMapping("/{billAccountId}")
//    public List<OrderResponse> getAllOrders(@PathVariable Integer billAccountId) {
//        return orderService.getAllOrders();
//    }
}

package com.turkcell.pair3.customerservice.controller;

import com.turkcell.pair3.customerservice.entity.Customer;
import com.turkcell.pair3.customerservice.service.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.service.dtos.requests.CustomerAddRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer add(@RequestBody CustomerAddRequest customerAddRequest) {
        return customerService.add(customerAddRequest);
    }
}

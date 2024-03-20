package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
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

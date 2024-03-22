package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.services.abstracts.AddressService;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressAddRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public Integer add(AddressAddRequest request) {
        return addressService.add(request);
    }
}

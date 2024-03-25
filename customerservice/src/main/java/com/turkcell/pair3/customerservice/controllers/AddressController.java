package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.services.abstracts.AddressService;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.AddressUpdateResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")

public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Integer add(AddressAddRequest request) {
        return addressService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public AddressUpdateResponse update(@PathVariable Integer id, @RequestBody AddressUpdateRequest request){
        return addressService.update(id, request);
    }
}

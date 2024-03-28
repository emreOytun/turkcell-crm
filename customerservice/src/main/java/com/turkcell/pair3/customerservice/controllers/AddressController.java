package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.services.abstracts.AddressService;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.AddressUpdateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public Integer add(@RequestBody @Valid AddressAddRequest request) {
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

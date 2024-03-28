package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchCustomerResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public CustomerAddResponse add(@RequestBody @Valid CustomerAddRequest customerAddRequest) {
        return customerService.add(customerAddRequest);
    }

    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody @Valid SearchCustomerRequest request)
    {
        return customerService.search(request);
    }

    @GetMapping("getInfo/{customerId}")
    public CustomerInfoResponse getInfo(@PathVariable @NotBlank String customerId)
    {
        return customerService.getCustomerInfo(customerId);
    }

    @GetMapping("getInfo/all")
    public List<Customer> getAll()
    {
        return customerService.getAll();
    }

}

package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.entities.IndividualCustomer;
import com.turkcell.pair3.customerservice.repositories.CustomerRepository;
import com.turkcell.pair3.customerservice.services.abstracts.IndividualCustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchIndividualCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchIndividualCustomerResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    public IndividualCustomerAddResponse add(@RequestBody @Valid IndividualCustomerAddRequest individualCustomerAddRequest) {
        return individualCustomerService.add(individualCustomerAddRequest);
    }

    @PostMapping("search")
    public List<SearchIndividualCustomerResponse> search(@RequestBody @Valid SearchIndividualCustomerRequest request)
    {
        return individualCustomerService.search(request);
    }

    @GetMapping("getInfo/{customerId}")
    public IndividualCustomerInfoResponse getInfo(@PathVariable @NotBlank String customerId)
    {
        return individualCustomerService.getCustomerInfo(customerId);
    }

//    @GetMapping("getInfo")
//    public List<IndividualCustomerInfoResponse> getAll(SearchByPageRequest searchByPageRequest)
//    {
//        return customerService.getAll();
//    }

    @PutMapping("/{id}")
    public IndividualCustomerInfoResponse updateCustomer(@PathVariable @NotNull Integer id, @RequestBody @Valid IndividualCustomerUpdateRequest request) {
        return individualCustomerService.update(id, request);
    }
}

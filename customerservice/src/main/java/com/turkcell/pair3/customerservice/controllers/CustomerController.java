package com.turkcell.pair3.customerservice.controllers;

import com.turkcell.pair3.customerservice.services.abstracts.IndividualCustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerContactUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerSearchRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    public IndividualCustomerAddResponse save(@RequestBody @Valid IndividualCustomerAddRequest individualCustomerAddRequest) {
        return individualCustomerService.saveCustomer(individualCustomerAddRequest);
    }

    // TODO not working
    @PostMapping("/search")
    public List<IndividualCustomerSearchResponse> searchCustomer(@RequestBody @Valid IndividualCustomerSearchRequest request)
    {
        return individualCustomerService.searchCustomer(request);
    }

    @GetMapping("/{customerId}")
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
        return individualCustomerService.updateCustomer(id, request);
    }

    @PostMapping("/checkNationalityId")
    public CheckNationalityIdResponse checkNationalityId(@RequestParam @NotBlank String nationalityId) {
        return individualCustomerService.checkNationalityId(nationalityId);
    }

    @DeleteMapping("/{customerId}")
    public IndividualCustomerDeleteResponse deleteCustomer(@PathVariable @NotBlank String customerId) {
        return individualCustomerService.deleteCustomer(customerId);
    }

    @PutMapping("/{customerId}/contact")
    public void updateContact(@PathVariable @NotBlank String customerId, @RequestBody @Valid IndividualCustomerContactUpdateRequest request) {
        individualCustomerService.updateContact(customerId, request);
    }

}

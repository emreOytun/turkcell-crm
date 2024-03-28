package com.turkcell.pair3.customerservice.services.abstracts;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchCustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerAddResponse add(CustomerAddRequest customerAddRequest);
    CustomerInfoResponse getCustomerInfo(String customerId);
    List<SearchCustomerResponse> search(SearchCustomerRequest request);
    CustomerInfoResponse update(Integer id, CustomerUpdateRequest request);
    List<Customer> getAll();
}

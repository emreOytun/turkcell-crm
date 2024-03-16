package com.turkcell.pair3.customerservice.service.abstracts;

import com.turkcell.pair3.customerservice.entity.Customer;
import com.turkcell.pair3.customerservice.service.dtos.requests.CustomerAddRequest;

public interface CustomerService {
    Customer add(CustomerAddRequest customerAddRequest);
}

package com.turkcell.pair3.customerservice.services.abstracts;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;

public interface CustomerService {
    Customer add(CustomerAddRequest customerAddRequest);
}

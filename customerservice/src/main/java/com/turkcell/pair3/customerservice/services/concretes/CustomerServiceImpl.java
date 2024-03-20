package com.turkcell.pair3.customerservice.services.concretes;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.repositories.CustomerRepository;
import com.turkcell.pair3.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.services.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public Customer add(CustomerAddRequest customerAddRequest) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(customerAddRequest);
        return customer;
    }
}

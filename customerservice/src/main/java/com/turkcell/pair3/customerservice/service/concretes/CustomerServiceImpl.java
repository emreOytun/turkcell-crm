package com.turkcell.pair3.customerservice.service.concretes;

import com.turkcell.pair3.customerservice.entity.Customer;
import com.turkcell.pair3.customerservice.repository.CustomerRepository;
import com.turkcell.pair3.customerservice.service.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.service.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.service.mapper.CustomerMapper;
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

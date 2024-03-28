package com.turkcell.pair3.customerservice.services.rules;

import com.turkcell.pair3.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.repositories.CustomerRepository;
import com.turkcell.pair3.customerservice.services.messages.CustomerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules
{
    private final CustomerRepository customerRepository;


    public void customerWithSameNationalityIdCanNotExist(int nationalityId)
    {
        Optional<Customer> customer = customerRepository.findByNationalityId(nationalityId);

        if(customer.isPresent())
            throw new BusinessException(CustomerMessages.CUSTOMER_WITH_SAME_IDENTITY_EXISTS);
    }
}

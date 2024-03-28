package com.turkcell.pair3.customerservice.services.concretes;

import com.turkcell.pair3.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.repositories.CustomerRepository;
import com.turkcell.pair3.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair3.customerservice.services.constants.Messages;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchCustomerResponse;
import com.turkcell.pair3.customerservice.services.mapper.CustomerMapper;
import com.turkcell.pair3.customerservice.services.messages.CustomerMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerAddResponse add(CustomerAddRequest customerAddRequest) {
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(customerAddRequest);

        customerRepository.save(customer);

        CustomerAddResponse response = CustomerMapper.INSTANCE.customerAddResponseFromCustomer(customer);

        return response;
    }

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        List<SearchCustomerResponse> response = customerRepository.search(request);

        if(response.isEmpty())
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);

        return response;
    }

    @Override
    public CustomerInfoResponse getCustomerInfo(String customerId){
        Optional<Customer> customer = customerRepository.findByCustomerId(customerId);

        if(customer.isEmpty()) {
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        return CustomerMapper.INSTANCE.customerInfoResponseFromCustomer(customer.get());
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerInfoResponse update(Integer id, CustomerUpdateRequest request){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        Customer updatedCustomer = customer.get();

        CustomerMapper.INSTANCE.updateCustomerField(updatedCustomer, request);

        updatedCustomer = customerRepository.save(updatedCustomer);

        return CustomerMapper.INSTANCE.customerInfoResponseFromCustomer(updatedCustomer);
    }

}

package com.turkcell.pair3.customerservice.services.concretes;

import com.turkcell.pair3.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair3.customerservice.entities.IndividualCustomer;
import com.turkcell.pair3.customerservice.repositories.IndividualCustomerRepository;
import com.turkcell.pair3.customerservice.services.abstracts.IndividualCustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerUpdateRequest;
import com.turkcell.pair3.customerservice.core.business.paging.SearchByPageRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchIndividualCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchIndividualCustomerResponse;
import com.turkcell.pair3.customerservice.services.mapper.IndividualCustomerMapper;
import com.turkcell.pair3.customerservice.services.messages.CustomerMessages;
import com.turkcell.pair3.customerservice.services.rules.CustomerBusinessRules;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerBusinessRules customerBusinessRules;

    public IndividualCustomerServiceImpl(IndividualCustomerRepository customerRepository, CustomerBusinessRules customerBusinessRules) {
        this.individualCustomerRepository = customerRepository;
        this.customerBusinessRules = customerBusinessRules;
    }

    @Override
    public IndividualCustomerAddResponse add(IndividualCustomerAddRequest individualCustomerAddRequest) {
        IndividualCustomer customer = IndividualCustomerMapper.INSTANCE.individualCustomerFromAddRequest(individualCustomerAddRequest);

        customerBusinessRules.customerWithSameNationalityIdCanNotExist(customer.getNationalityId());

        individualCustomerRepository.save(customer);

        IndividualCustomerAddResponse response = IndividualCustomerMapper.INSTANCE.individualCustomerAddResponseFromCustomer(customer);

        return response;
    }

    @Override
    public List<SearchIndividualCustomerResponse> search(SearchIndividualCustomerRequest request) {
            List<SearchIndividualCustomerResponse> response = individualCustomerRepository.search(request);

            if(response.isEmpty()) {
                throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
            }

            return response;
    }

    @Override
    public IndividualCustomerInfoResponse getCustomerInfo(String customerId){
        Optional<IndividualCustomer> customer = individualCustomerRepository.findByCustomerId(customerId);

        if(customer.isEmpty()) {
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        return IndividualCustomerMapper.INSTANCE.individualCustomerInfoResponseFromCustomer(customer.get());
    }

    @Override
    public List<IndividualCustomerInfoResponse> getAll(SearchByPageRequest searchByPageRequest) {
        //TODO: will be replaced with paginated find method
        Pageable pageable = PageRequest.of(searchByPageRequest.getPageNo(), searchByPageRequest.getPageSize());
        return IndividualCustomerMapper.INSTANCE.individualCustomerInfoResponsesFromCustomers(individualCustomerRepository.findAll(pageable).stream().toList());
    }

    @Override
    public IndividualCustomerInfoResponse update(Integer id, IndividualCustomerUpdateRequest request){
        Optional<IndividualCustomer> customer = individualCustomerRepository.findById(id);

        if(customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        IndividualCustomer updatedCustomer = customer.get();

        IndividualCustomerMapper.INSTANCE.updateIndividualCustomerField(updatedCustomer, request);

        updatedCustomer = individualCustomerRepository.save(updatedCustomer);

        return IndividualCustomerMapper.INSTANCE.individualCustomerInfoResponseFromCustomer(updatedCustomer);
    }
}

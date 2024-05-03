package com.turkcell.pair3.customerservice.services.concretes;

import com.turkcell.pair3.core.enums.EnumState;
import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.customerservice.core.business.paging.SearchByPageRequest;
import com.turkcell.pair3.customerservice.entities.IndividualCustomer;
import com.turkcell.pair3.customerservice.repositories.IndividualCustomerRepository;
import com.turkcell.pair3.customerservice.services.abstracts.IndividualCustomerService;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerContactUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerSearchRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.*;
import com.turkcell.pair3.customerservice.services.mapper.IndividualCustomerMapper;
import com.turkcell.pair3.customerservice.services.messages.CustomerMessages;
import com.turkcell.pair3.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public IndividualCustomerAddResponse saveCustomer(IndividualCustomerAddRequest individualCustomerAddRequest) {
        IndividualCustomer customer = IndividualCustomerMapper.INSTANCE.individualCustomerFromAddRequest(individualCustomerAddRequest);

        individualCustomerBusinessRules.customerWithSameNationalityIdCanNotExist(customer.getNationalityId());
        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setState(EnumState.ACTIVE);
        individualCustomerRepository.save(customer);

        IndividualCustomerAddResponse response = IndividualCustomerMapper.INSTANCE.individualCustomerAddResponseFromCustomer(customer);

        return response;
    }

    @Override
    public List<IndividualCustomerSearchResponse> searchCustomer(IndividualCustomerSearchRequest request) {
            List<IndividualCustomerSearchResponse> response = individualCustomerRepository.search(request);

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
    public CheckNationalityIdResponse checkNationalityId(String nationalityId) {
        return new CheckNationalityIdResponse(individualCustomerRepository.existsByNationalityId(nationalityId));
    }

    @Override
    public IndividualCustomerInfoResponse updateCustomer(Integer id, IndividualCustomerUpdateRequest request){
        Optional<IndividualCustomer> customer = individualCustomerRepository.findById(id);

        if(customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        IndividualCustomer updatedCustomer = customer.get();

        if(individualCustomerRepository.existsByNationalityId(request.getNationalityId()) && !updatedCustomer.getNationalityId().equals(request.getNationalityId())){
            throw new BusinessException(CustomerMessages.NATIONALITY_ID_ALREADY_EXISTS);
        }

        IndividualCustomerMapper.INSTANCE.updateIndividualCustomerField(updatedCustomer, request);

        updatedCustomer = individualCustomerRepository.save(updatedCustomer);

        return IndividualCustomerMapper.INSTANCE.individualCustomerInfoResponseFromCustomer(updatedCustomer);
    }

    @Override
    public IndividualCustomerDeleteResponse deleteCustomer(String customerId) {
        Optional<IndividualCustomer> customer = individualCustomerRepository.findByCustomerId(customerId);

        if(customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        //TODO : Eğer aktif bir ürünü varsa “Since the customer has active products,
        // the customer cannot be deleted.” Uyarı mesajı gösterilecektir.
        customer.get().setState(EnumState.PASSIVE);
        individualCustomerRepository.save(customer.get());

        return IndividualCustomerMapper.INSTANCE.individualCustomerDeleteResponseFromCustomer(customer.get());
    }

    @Override
    public void updateContact(String customerId, IndividualCustomerContactUpdateRequest request) {
        Optional<IndividualCustomer> customer = individualCustomerRepository.findByCustomerId(customerId);

        if(customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NO_CUSTOMER_FOUND);
        }

        IndividualCustomer updatedCustomer = customer.get();
        updatedCustomer.setEmail(request.getEmail());
        updatedCustomer.setGsmNumber(request.getMobilePhone());
        updatedCustomer.setHomePhone(request.getHomePhone());
        updatedCustomer.setFax(request.getFax());

        updatedCustomer = individualCustomerRepository.save(updatedCustomer);
    }
}

package com.turkcell.pair3.customerservice.services.abstracts;

import com.turkcell.pair3.customerservice.core.business.paging.SearchByPageRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchIndividualCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerAddResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerInfoResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    IndividualCustomerAddResponse add(IndividualCustomerAddRequest individualCustomerAddRequest);
    IndividualCustomerInfoResponse getCustomerInfo(String customerId);
    List<SearchIndividualCustomerResponse> search(SearchIndividualCustomerRequest request);
    IndividualCustomerInfoResponse update(Integer id, IndividualCustomerUpdateRequest request);
    List<IndividualCustomerInfoResponse> getAll(SearchByPageRequest searchByPageRequest);
}

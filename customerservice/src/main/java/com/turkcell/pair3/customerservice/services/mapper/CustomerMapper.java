package com.turkcell.pair3.customerservice.services.mapper;

import com.turkcell.pair3.customerservice.entities.Address;
import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.services.dtos.requests.AddressUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.CustomerUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.AddressUpdateResponse;
import com.turkcell.pair3.customerservice.services.dtos.responses.CustomerInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerFromAddRequest(CustomerAddRequest request);

    @Mapping(target="id", ignore=true)
    void updateCustomerField(@MappingTarget Customer customer, CustomerUpdateRequest request);


    CustomerInfoResponse customerInfoResponseFromCustomer(Customer customer);
}

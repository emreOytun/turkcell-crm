package com.turkcell.pair3.customerservice.service.mapper;

import com.turkcell.pair3.customerservice.entity.Customer;
import com.turkcell.pair3.customerservice.service.dtos.requests.CustomerAddRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerFromAddRequest(CustomerAddRequest request);
}

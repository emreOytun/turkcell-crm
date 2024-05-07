package com.turkcell.pair3.invoiceservice.services.mapper;

import com.turkcell.pair3.invoiceservice.services.dtos.request.AddBillAddressRequest;
import com.turkcell.pair3.invoiceservice.services.dtos.request.BillAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillAddressMapper {
    BillAddressMapper INSTANCE = Mappers.getMapper(BillAddressMapper.class);

}

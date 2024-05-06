package com.turkcell.pair3.productservice.services.mappers;

import com.turkcell.pair3.productservice.entities.Product;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product productFromAddRequest(AddProductRequest addProductRequest);

}

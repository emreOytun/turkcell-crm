package com.turkcell.pair3.productservice.services.mappers;

import com.turkcell.pair3.productservice.entities.CartProducts;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductToCartRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartProductsMapper {
    CartProductsMapper INSTANCE = Mappers.getMapper(CartProductsMapper.class);

    CartProducts cartProductFromRequest(AddProductToCartRequest addProductToCartRequest);
}

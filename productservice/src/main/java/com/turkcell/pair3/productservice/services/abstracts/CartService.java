package com.turkcell.pair3.productservice.services.abstracts;

import com.turkcell.pair3.core.events.CartProductEvent;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductToCartRequest;

import java.util.List;

public interface CartService {
    void addProductToCart(AddProductToCartRequest addProductToCartRequest);
    Integer createCartforCustomer(Integer customerId);
    List<Integer> getCartProducts(Integer cartId);

    List<CartProductEvent> getProductsByCartId(Integer cartId);
}

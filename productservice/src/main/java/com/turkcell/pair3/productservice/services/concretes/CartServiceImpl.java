package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.core.events.CartProductEvent;
import com.turkcell.pair3.productservice.entities.Cart;
import com.turkcell.pair3.productservice.entities.CartProducts;
import com.turkcell.pair3.productservice.repositories.CartProductRepository;
import com.turkcell.pair3.productservice.repositories.CartRepository;
import com.turkcell.pair3.productservice.services.abstracts.CartService;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductToCartRequest;
import com.turkcell.pair3.productservice.services.mappers.CartProductsMapper;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;

    @Override
    public void addProductToCart(AddProductToCartRequest addProductToCartRequest) {
        CartProducts cartProducts = CartProductsMapper.INSTANCE.cartProductFromRequest(addProductToCartRequest);
        cartProductRepository.save(cartProducts);
    }

    @Override
    public Integer createCartforCustomer(Integer customerId){
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        return cartRepository.save(cart).getId();
    }

    @Override
    public List<Integer> getCartProducts(Integer cartId){
        List<CartProducts> cartProductList = cartProductRepository.findAllByCartId(cartId);
        List<Integer> productIdList = cartProductList.stream().map(CartProducts::getProductId).toList();

        return productIdList;
    }

    @Override
    public List<CartProductEvent> getProductsByCartId(Integer cartId) {
        List<CartProducts> cartProductList = cartProductRepository.findAllByCartId(cartId);
        List<CartProductEvent> cartProductEventList = new ArrayList<>();
        for(CartProducts cartProducts : cartProductList){
            CartProductEvent cartProductEvent = new CartProductEvent();
            cartProductEvent.setProductId(cartProducts.getProductId());
            cartProductEvent.setProductSpecId(cartProducts.getProductSpecId());
            cartProductEvent.setCartId(cartProducts.getCartId());
            cartProductEventList.add(cartProductEvent);
        }

        return cartProductEventList;
    }


}

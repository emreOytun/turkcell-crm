package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.core.events.CartProductEvent;
import com.turkcell.pair3.productservice.services.abstracts.CartService;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductToCartRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/carts")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    //add product to cart
    @PostMapping("/addProduct")
    public void addProductToCart(@RequestBody AddProductToCartRequest addProductToCartRequest) {
        cartService.addProductToCart(addProductToCartRequest);
    }

    @GetMapping("/{customerId}/getCartProducts")
    public List<Integer> getCartProducts(@PathVariable Integer customerId) {
        return cartService.getCartProducts(customerId);
    }

    @PostMapping("/{customerId}/createCart")
    public Integer createCart(@PathVariable Integer customerId) {
        return cartService.createCartforCustomer(customerId);
    }

    @GetMapping("/{cartId}/getProductsByCartId")
    public List<CartProductEvent> getProductsByCartId(@PathVariable Integer cartId) {
        return cartService.getProductsByCartId(cartId);
    }



}

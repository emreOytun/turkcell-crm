package com.turkcell.pair3.orderservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import com.turkcell.pair3.events.CartProductEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="productservice", configuration = FeignClientConfiguration.class)
public interface ProductServiceClient {

    @GetMapping("/api/products/findProductPriceById/{id}")
    double findProductPriceById(@PathVariable("id") Integer id);

    @GetMapping("/api/carts/{cartId}/getProductsByCartId")
    List<CartProductEvent> getProductsByCartId(@PathVariable("cartId") Integer cartId);

}
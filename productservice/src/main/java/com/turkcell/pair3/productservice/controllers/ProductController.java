package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.core.events.CartProductEvent;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.turkcell.pair3.productservice.services.abstracts.ProductService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/findProductPriceById/{id}")
    public double findProductPriceById(@PathVariable int id) {
        return productService.findProductPriceById(id);
    }

    @PostMapping
    public void create(@RequestBody AddProductRequest addProductRequest) {
        productService.create(addProductRequest);
    }

    @GetMapping("/{cartId}/getProductsByCartId")
    List<CartProductEvent> getProductsByCartId(@PathVariable Integer cartId){
        return null;
    }


}

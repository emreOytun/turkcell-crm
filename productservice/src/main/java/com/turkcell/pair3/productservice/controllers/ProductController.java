package com.turkcell.pair3.productservice.controllers;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.turkcell.pair3.productservice.services.abstracts.ProductService;

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

}

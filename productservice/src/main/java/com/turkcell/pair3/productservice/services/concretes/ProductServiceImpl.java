package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.productservice.entities.Product;
import com.turkcell.pair3.productservice.repositories.ProductRepository;
import com.turkcell.pair3.productservice.services.abstracts.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public double findProductPriceById(int id) {
        Product product = productRepository.findProductPriceById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getProductPrice();
    }
}

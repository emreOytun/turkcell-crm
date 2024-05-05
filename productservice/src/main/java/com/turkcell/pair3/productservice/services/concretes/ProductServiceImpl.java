package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.messages.Messages;
import com.turkcell.pair3.productservice.entities.Product;
import com.turkcell.pair3.productservice.repositories.ProductRepository;
import com.turkcell.pair3.productservice.services.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MessageService messageService;

    @Override
    public double findProductPriceById(int id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.NO_PRODUCT_FOUND_GIVEN_ID)));

        return product.getPrice();
    }
}

package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.core.messages.Messages;
import com.turkcell.pair3.productservice.entities.Product;
import com.turkcell.pair3.productservice.repositories.CategoryRepository;
import com.turkcell.pair3.productservice.repositories.ProductRepository;
import com.turkcell.pair3.productservice.services.abstracts.ProductService;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductRequest;
import com.turkcell.pair3.productservice.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MessageService messageService;
    private final CategoryRepository categoryRepository;

    @Override
    public double findProductPriceById(int id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.NO_PRODUCT_FOUND_GIVEN_ID)));

        return product.getPrice();
    }

    @Override
    public void create(AddProductRequest addProductRequest) {
        Product product = ProductMapper.INSTANCE.productFromAddRequest(addProductRequest);
        product.setQuantity(addProductRequest.getQuantity());
        product.setPrice(addProductRequest.getPrice());
        product.setOfferId(addProductRequest.getOfferId());
        System.out.println(addProductRequest.getCategoryId());
        product.setCategory(categoryRepository.findById(addProductRequest.getCategoryId())
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.PRODUCT_HAS_NO_CATEGORY))));
        product.setProductName(addProductRequest.getProductName());
        productRepository.save(product);
    }
}

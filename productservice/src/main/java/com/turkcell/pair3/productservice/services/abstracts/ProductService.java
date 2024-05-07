package com.turkcell.pair3.productservice.services.abstracts;

import com.turkcell.pair3.productservice.services.dto.requests.AddProductRequest;

public interface ProductService {

    double findProductPriceById(int id);
    void create(AddProductRequest addProductRequest);

}

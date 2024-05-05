package com.turkcell.pair3.productservice.services.abstracts;

import com.turkcell.pair3.productservice.services.dto.requests.AddCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.requests.UpdateCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddCategoryResponse;

public interface CategoryService {
    AddCategoryResponse add(AddCategoryRequest request);

    void update(UpdateCategoryRequest request);

}

package com.turkcell.pair3.productservice.services.mappers;

import com.turkcell.pair3.productservice.entities.Category;
import com.turkcell.pair3.productservice.services.dto.requests.AddCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.requests.UpdateCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    AddCategoryResponse responseFromAddRequest(Category category);

    AddCategoryResponse addCategoryResponse(Category category);

    Category addCategoryRequest(AddCategoryRequest request);

    Category updateCategoryFromRequest(UpdateCategoryRequest request);
}

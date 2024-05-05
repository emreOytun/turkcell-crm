package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.productservice.entities.Category;
import com.turkcell.pair3.productservice.repositories.CategoryRepository;
import com.turkcell.pair3.productservice.services.abstracts.CategoryService;
import com.turkcell.pair3.productservice.services.dto.requests.AddCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.requests.UpdateCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddCategoryResponse;
import com.turkcell.pair3.productservice.services.mappers.CategoryMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public AddCategoryResponse add(AddCategoryRequest request){
        Category category = CategoryMapper.INSTANCE.addCategoryRequest(request);
        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.addCategoryResponse(category);
    }

    @Override
    public void update(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.updateCategoryFromRequest(request);
        categoryRepository.save(category);
    }

}
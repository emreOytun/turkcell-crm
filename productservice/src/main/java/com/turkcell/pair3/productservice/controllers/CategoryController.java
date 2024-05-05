package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.productservice.services.abstracts.CategoryService;
import com.turkcell.pair3.productservice.services.dto.requests.AddCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.requests.UpdateCategoryRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

        private final CategoryService categoryService;

        @PostMapping("add")
        @ResponseStatus(HttpStatus.CREATED)
        public AddCategoryResponse add(@Valid @RequestBody AddCategoryRequest request) {
                return categoryService.add(request);
        }

        @PutMapping("updateCategory")
        @ResponseStatus(HttpStatus.OK)
        public void update(@RequestBody @Valid UpdateCategoryRequest request) {
                categoryService.update(request);
        }
}

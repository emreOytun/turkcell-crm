package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.productservice.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

        private final CategoryService categoryService;
}

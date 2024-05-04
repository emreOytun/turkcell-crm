package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.productservice.entities.Specification;
import com.turkcell.pair3.productservice.services.abstracts.SpecificationService;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AddSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AssignProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddProductSpecificationResponse;
import com.turkcell.pair3.productservice.services.dto.responses.AddSpecificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/specifications")
@AllArgsConstructor
public class SpecificationController {

    private final SpecificationService specificationService;

    //create a new specification
    @PostMapping("/create")
    public AddSpecificationResponse createSpecification(@RequestBody AddSpecificationRequest request) {
      return specificationService.createSpecification(request);
    }

    @PostMapping("/createProductSpec")
    public AddProductSpecificationResponse createProductSpec(@RequestBody AddProductSpecificationRequest request) {
        return specificationService.createProductSpec(request);
    }

    @PostMapping("/assignProductSpec")
    public Integer assignProductSpec(@RequestBody AssignProductSpecificationRequest request) {
        return specificationService.assignProductSpec(request);
    }



}

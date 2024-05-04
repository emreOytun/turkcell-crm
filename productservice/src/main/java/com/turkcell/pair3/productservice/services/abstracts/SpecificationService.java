package com.turkcell.pair3.productservice.services.abstracts;

import com.turkcell.pair3.productservice.services.dto.requests.AddProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AddSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AssignProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddProductSpecificationResponse;
import com.turkcell.pair3.productservice.services.dto.responses.AddSpecificationResponse;

public interface SpecificationService {
    AddSpecificationResponse createSpecification(AddSpecificationRequest request);

    AddProductSpecificationResponse createProductSpec(AddProductSpecificationRequest request);

    Integer assignProductSpec(AssignProductSpecificationRequest request);
}

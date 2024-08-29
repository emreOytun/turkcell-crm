package com.turkcell.pair3.productservice.services.concretes;

import com.turkcell.pair3.core.exception.types.BusinessException;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.core.messages.Messages;
import com.turkcell.pair3.productservice.entities.Product;
import com.turkcell.pair3.productservice.entities.ProductSpecDetails;
import com.turkcell.pair3.productservice.entities.Specification;
import com.turkcell.pair3.productservice.repositories.ProductRepository;
import com.turkcell.pair3.productservice.repositories.ProductSpecDetailsRepository;
import com.turkcell.pair3.productservice.repositories.SpecificationRepository;
import com.turkcell.pair3.productservice.services.abstracts.SpecificationService;
import com.turkcell.pair3.productservice.services.dto.requests.AddProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AddSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.requests.AssignProductSpecificationRequest;
import com.turkcell.pair3.productservice.services.dto.responses.AddProductSpecificationResponse;
import com.turkcell.pair3.productservice.services.dto.responses.AddSpecificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationRepository specificationRepository;
    private final ProductSpecDetailsRepository productSpecDetailsRepository;
    private final MessageService messageService;
    private final ProductRepository productRepository;

    @Override
    public AddSpecificationResponse createSpecification(AddSpecificationRequest request) {
        Specification specification = new Specification();
        specification.setSpecName(request.getSpecName());

        specificationRepository.save(specification);
        AddSpecificationResponse response = new AddSpecificationResponse();
        response.setName(specification.getSpecName());
        return response;
    }

    @Override
    public AddProductSpecificationResponse createProductSpec(AddProductSpecificationRequest request) {
        ProductSpecDetails productSpecDetails = new ProductSpecDetails();
        Optional<Specification> specification = specificationRepository.findById(request.getSpecificationId());
        if (specification.isPresent()) {
            productSpecDetails.setSpecification(specification.get());
            productSpecDetails.setSpecValue(request.getValue());
            productSpecDetailsRepository.save(productSpecDetails);
            AddProductSpecificationResponse response = new AddProductSpecificationResponse();
            response.setSpecValue(productSpecDetails.getSpecValue());
            response.setSpecName(specification.get().getSpecName());
            return response;
        } else {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.SPECIFICATION_NOT_FOUND));
        }

    }

    @Override
    public Integer assignProductSpec(AssignProductSpecificationRequest request) {
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.PRODUCT_NOT_FOUND)));
        Specification specification = specificationRepository.findById(request.getSpecificationId()).orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.BusinessErrors.SPECIFICATION_NOT_FOUND)));
        product.getSpecifications().add(specification);
        Integer result = productRepository.save(product).getId();
        return result;
    }
}

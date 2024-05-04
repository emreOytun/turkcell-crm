package com.turkcell.pair3.productservice.services.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignProductSpecificationRequest {
    @NotNull
    private Integer productId;

    @NotNull
    private Integer specificationId;
}

package com.turkcell.pair3.productservice.services.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductSpecificationRequest {

    @NotNull
    private Integer specificationId;

    @NotNull
    private String value;
}

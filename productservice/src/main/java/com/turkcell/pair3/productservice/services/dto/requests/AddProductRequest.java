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
public class AddProductRequest {

    private String productName;
    private Integer categoryId;
    private Integer offerId;
    private Integer quantity;
    private Double price;

}

package com.turkcell.pair3.productservice.services.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductSpecificationResponse {

    private String specName;
    private String specValue;

}

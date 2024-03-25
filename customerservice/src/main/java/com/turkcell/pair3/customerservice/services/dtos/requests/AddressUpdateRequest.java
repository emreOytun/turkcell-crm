package com.turkcell.pair3.customerservice.services.dtos.requests;

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
public class AddressUpdateRequest {
    @NotNull
    private int id;

    @NotNull
    private int cityId;

    @NotBlank(message = "Street is mandatory.")
    private String street;

    @NotBlank(message = "House/Flat number is mandatory.")
    private String flatNumber;

}

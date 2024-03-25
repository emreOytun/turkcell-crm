package com.turkcell.pair3.customerservice.services.dtos.requests;

import com.turkcell.pair3.customerservice.enums.EnumGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private EnumGender gender;

    @NotBlank
    private String motherName;

    @NotBlank
    private String fatherName;

    @NotBlank
    private String secondName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private int nationalityId;
}

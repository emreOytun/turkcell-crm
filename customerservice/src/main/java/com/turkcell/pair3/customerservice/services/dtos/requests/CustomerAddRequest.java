package com.turkcell.pair3.customerservice.services.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerAddRequest {
    @NotBlank
    private String accountNumber;

    @NotBlank
    private String email;

    @NotBlank
    private String nationalId;

    @NotBlank
    private String gsmNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String midName;

    @NotBlank
    private String role;

    @NotBlank
    private Date birthDate;

    @NotBlank
    private String gender;

    private String fatherName;

    private String motherName;

    private String homePhone;

    @NotBlank
    private String mobilePhone;

    private String fax;
}

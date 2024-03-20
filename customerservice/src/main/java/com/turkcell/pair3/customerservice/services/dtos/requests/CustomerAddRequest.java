package com.turkcell.pair3.customerservice.services.dtos.requests;

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
    private String accountNumber;
    private String email;
    private String nationalId;
    private String gsmNumber;
    private String firstName;
    private String lastName;
    private String midName;
    private String role;
    private Date birthDate;
    private String gender;
    private String fatherName;
    private String motherName;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}

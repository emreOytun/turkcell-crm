package com.turkcell.pair3.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "national_id", nullable = false)
    private String nationalId;

    @Column(name = "gsm_number", nullable = false)
    private String gsmNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "address")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Address> address;
}

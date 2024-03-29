package com.turkcell.pair3.customerservice.entities;

import com.turkcell.pair3.customerservice.enums.EnumGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="customer_id")
    private String customerId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    //@Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nationality_id", nullable = false)
    private int nationalityId;

    @Column(name = "gsm_number", nullable = false)
    private String gsmNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="second_name")
    private String secondName;

    @Column(name = "role", nullable = false)
    private String role;

    //TODO: birthdate should be in the past localdate is not a good choice
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumGender gender;

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

package com.turkcell.pair3.customerservice.entities;

import com.turkcell.pair3.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="customer_id")
    private String customerId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gsm_number", nullable = false)
    private String gsmNumber;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "fax")
    private String fax;

    @Column(name = "address")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Address> address;
}

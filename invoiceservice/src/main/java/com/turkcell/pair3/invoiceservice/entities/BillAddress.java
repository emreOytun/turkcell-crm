package com.turkcell.pair3.invoiceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bill_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "bill_account_id")
    @ManyToOne
    private BillAccount billAccount;

    @Column(name="address_id")
    private int addressId;
}

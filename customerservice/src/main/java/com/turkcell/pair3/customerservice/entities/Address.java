package com.turkcell.pair3.customerservice.entities;

import com.turkcell.pair3.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity<Integer> {

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "customer_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;
}

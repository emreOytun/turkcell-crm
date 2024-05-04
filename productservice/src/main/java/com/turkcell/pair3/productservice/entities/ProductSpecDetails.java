package com.turkcell.pair3.productservice.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_spec_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        @JoinColumn(name = "specification_id")
        private Specification specification;

        @Column(name = "spec_value", nullable = false)
        private String specValue;
}

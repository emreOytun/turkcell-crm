package com.turkcell.pair3.productservice.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "specifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "spec_name", nullable = false)
    private String specName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "specification")
    private List<ProductSpecDetails> productSpecDetails;

    @ManyToMany(mappedBy = "specifications")
    private List<Product> products;

}

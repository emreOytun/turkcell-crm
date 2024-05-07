package com.turkcell.pair3.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProducts {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer productId;

        @Column(name = "cart_id", nullable = false)
        private Integer cartId;

        @Column(name = "product_spec_id", nullable = false)
        private Integer productSpecId;

}

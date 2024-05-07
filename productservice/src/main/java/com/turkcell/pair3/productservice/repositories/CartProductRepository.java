package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.productservice.entities.CartProducts;
import com.turkcell.pair3.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProducts, Integer> {

    List<CartProducts> findAllByCartId(Integer cartId);

}

package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.events.ProductEvent;
import com.turkcell.pair3.productservice.entities.Cart;
import com.turkcell.pair3.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer>{


}

package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.productservice.entities.ProductSpecDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecDetailsRepository extends JpaRepository<ProductSpecDetails, Integer> {
}

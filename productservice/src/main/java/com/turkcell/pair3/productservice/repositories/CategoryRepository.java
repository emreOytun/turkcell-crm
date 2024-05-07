package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.productservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

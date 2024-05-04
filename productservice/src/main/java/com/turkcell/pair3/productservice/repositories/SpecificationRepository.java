package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.productservice.entities.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Integer> {
}

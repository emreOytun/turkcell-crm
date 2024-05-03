package com.turkcell.pair3.productservice.repositories;

import com.turkcell.pair3.productservice.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}

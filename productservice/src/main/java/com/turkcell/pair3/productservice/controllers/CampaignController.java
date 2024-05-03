package com.turkcell.pair3.productservice.controllers;

import com.turkcell.pair3.productservice.services.abstracts.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/campaigns")
@AllArgsConstructor
public class CampaignController {

        private final CampaignService campaignService;
}

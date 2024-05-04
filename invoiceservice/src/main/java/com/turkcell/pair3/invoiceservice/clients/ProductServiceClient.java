package com.turkcell.pair3.invoiceservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice", configuration = FeignClientConfiguration.class)
public interface ProductServiceClient {
    @GetMapping("/api/products/hasProduct")
    boolean hasAccountProduct(@RequestParam("billAccountId") int accountId);
}

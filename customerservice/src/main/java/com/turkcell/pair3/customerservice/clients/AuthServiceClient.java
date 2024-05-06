package com.turkcell.pair3.customerservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import com.turkcell.pair3.events.RegisterEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authservice",path = "/api/v1/auth", configuration = FeignClientConfiguration.class)
public interface AuthServiceClient {

    @PostMapping("/register")
    Integer register(@RequestBody RegisterEvent request);

}

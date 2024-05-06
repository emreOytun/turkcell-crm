package com.turkcell.pair3.customerservice.clients;

import com.turkcell.pair3.core.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="authservice",path = "/api/v1/auth", configuration = FeignClientConfiguration.class)
public class AuthServiceClient {


}

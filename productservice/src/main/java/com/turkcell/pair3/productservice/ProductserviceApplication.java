package com.turkcell.pair3.productservice;

import com.turkcell.pair3.core.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSecurity
@SpringBootApplication
public class ProductserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

}

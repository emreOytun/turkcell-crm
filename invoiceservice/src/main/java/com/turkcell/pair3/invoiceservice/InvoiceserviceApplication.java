package com.turkcell.pair3.invoiceservice;

import com.turkcell.pair3.core.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableSecurity
public class InvoiceserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceserviceApplication.class, args);
    }

}

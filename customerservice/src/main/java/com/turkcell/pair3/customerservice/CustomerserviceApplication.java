package com.turkcell.pair3.customerservice;

import com.turkcell.pair3.core.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableSecurity
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

}

/*

discovery server - gateway server : didar
core(security) - authservice : ersel
customer service(service(abstract,concrete), exceptions,rules,messages) : furkan
customer service(repositories,entities) : betül
service(dto,mapper,constants) : emre
configserver - configfiles : ahmet
docker-compose - dockerfile - core : taha
controller - feignclient - dependencies : arda

 */
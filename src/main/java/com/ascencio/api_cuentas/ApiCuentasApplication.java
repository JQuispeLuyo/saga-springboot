package com.ascencio.api_cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@SpringBootApplication
public class ApiCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCuentasApplication.class, args);
	}

}

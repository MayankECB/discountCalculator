package com.calculate.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DiscountCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountCalculatorApplication.class, args);
	}

}

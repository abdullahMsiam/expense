package com.user.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExpenseApplication.class, args);
		System.out.println("Spring Boot Application Started Successfully.");
	}

}

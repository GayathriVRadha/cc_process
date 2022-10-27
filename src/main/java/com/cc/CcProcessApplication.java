package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cc.*"})
@SpringBootApplication
public class CcProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcProcessApplication.class, args);
	}
}

package com.interview.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.interview.h2.dao")
public class H2Application {
//TODO Add jasypt and encrypt passwords
	public static void main(String[] args) {
		SpringApplication.run(H2Application.class, args);
	}
}

package com.pds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication()
@EntityScan("models")
public class PdsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdsWebApplication.class, args);
	}

}

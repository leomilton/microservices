package com.epam.microrecipient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MicroRecipientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroRecipientApplication.class, args);
	}

}

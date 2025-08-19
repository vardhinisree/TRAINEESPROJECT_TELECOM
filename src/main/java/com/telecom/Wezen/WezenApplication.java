package com.telecom.Wezen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WezenApplication {

	public static void main(String[] args) {
		SpringApplication.run(WezenApplication.class, args);
	}

}

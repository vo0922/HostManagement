package com.example.HostManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HostManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostManagementApplication.class, args);
	}

}

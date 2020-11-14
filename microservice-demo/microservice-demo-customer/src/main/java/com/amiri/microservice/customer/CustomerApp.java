package com.amiri.microservice.customer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
@Component
public class CustomerApp {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerApp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void generateTestData() {
		customerRepository.save(new Customer("Khaled", "Amiri",
				"khaled.amiri@gmail.com", "Bousselssla", "La marsa"));
		customerRepository.save(new Customer("Tarek", "Amiri",
				"tarek.amiri@gmail.com", "Bousselssla", "La marsa"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}

}

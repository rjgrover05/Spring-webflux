package com.first.reactivems;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.first.reactivems.entity.Customer;
import com.first.reactivems.repository.CustomerRepository;

import reactor.core.publisher.Mono;

/**
 * 
 * @author rgrover
 *
 */

@EnableMongoAuditing
@EnableMongoRepositories
@SpringBootApplication
public class CustomerReactiveMsService implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerReactiveMsService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setName("Raj");
		customer.setCustomerId(101);
		customer.setMobile("8708017842");
		customer.setAddress("Haryana");
		
	   Mono<Customer> monoCustomer = customerRepository.save(customer);
	   monoCustomer.block();
	   
	}

}

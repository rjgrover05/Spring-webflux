package com.first.reactivems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.reactivems.entity.Customer;
import com.first.reactivems.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author rgrover
 *
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Mono<Customer> createCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public Mono<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Integer id){
		return customerService.updateCustomer(customer, id);
	}
	
	@GetMapping("/{id}")
	public Mono<Customer> findOne(@PathVariable Integer id){
		return customerService.findOne(id);
	}
	
	@GetMapping
	public Flux<Customer> findAll(){
		return customerService.findAll();
	} 
	
	@DeleteMapping("/{id}")
	public Mono<Boolean> deleteCustomer(@PathVariable Integer id){
		return customerService.delete(id);
	}
}

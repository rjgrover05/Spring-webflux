package com.first.reactivems.service;

import com.first.reactivems.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author rgrover
 *
 */

public interface CustomerService {

	Mono<Customer> createCustomer(Customer Customer);

	Mono<Customer> updateCustomer(Customer Customer, Integer id);

	Flux<Customer> findAll();

	Mono<Customer> findOne(Integer id);

	Mono<Boolean> delete(Integer id);
}

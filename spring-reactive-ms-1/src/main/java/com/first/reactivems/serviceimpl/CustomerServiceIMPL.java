package com.first.reactivems.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.reactivems.entity.Customer;
import com.first.reactivems.repository.CustomerRepository;
import com.first.reactivems.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author rgrover
 *
 */

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 
	 * @param Customer type
	 * 
	 */
	@Override
	public Mono<Customer> createCustomer(Customer customer) {
		return customerRepository.insert(customer);
	}

	@Override
	public Mono<Customer> updateCustomer(Customer customer, Integer id) {
		return findOne(id).doOnSuccess(findCustomer -> {
			findCustomer.setName(customer.getName());
			findCustomer.setMobile(customer.getMobile());
			findCustomer.setAddress(customer.getAddress());

			customerRepository.save(findCustomer).subscribe();
		});
	}

	@Override
	public Flux<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Mono<Customer> findOne(Integer id) {
		return customerRepository.findById(id)
				.switchIfEmpty(Mono.error(new Exception("No Customer found with given id: " + id)));
	}

	@Override
	public Mono<Boolean> delete(Integer id) {
		return findOne(id).doOnSuccess(customer -> customerRepository.delete(customer).subscribe())
				.flatMap(customer -> Mono.just(Boolean.TRUE));
	}

}

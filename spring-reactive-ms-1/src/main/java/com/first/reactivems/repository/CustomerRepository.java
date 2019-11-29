package com.first.reactivems.repository;

import com.first.reactivems.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author rgrover
 *
 */

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,Integer> {
}

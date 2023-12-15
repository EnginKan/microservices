package com.yeditepe.comp301.microservices.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    public Customer findByUsername(String username);
}

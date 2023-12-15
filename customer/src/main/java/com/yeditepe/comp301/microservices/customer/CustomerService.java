package com.yeditepe.comp301.microservices.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean saveCustomer(CustomerRecord customer){
        if(!this.isExist(customer)) {
            customerRepository.save(new Customer.CustomerBuilder()
                    .username(customer.username())
                    .password(customer.password())
                    .email(customer.email())
                    .build());
            return true;
        }
        else
            return false;


    }

    private boolean isExist(CustomerRecord customerRecord){
        return customerRepository.findByUsername(customerRecord.username())!=null;
    }
}

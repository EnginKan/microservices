package com.yeditepe.comp301.microservices.customer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="fraud-service",url = "localhost:8082/api/v1/fraud")
public interface MyFeignClient {

    @GetMapping("/customer/{id}")
    public FraudResponse getFraudResponse(@PathVariable("id") int id);
}

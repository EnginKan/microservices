package com.yeditepe.comp301.microservices.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private RestTemplate restTemplate;
    private MyFeignClient myFeignClient;

    @PostMapping("/save")
    public ResponseEntity saveCustomer(@RequestBody CustomerRecord record) {
        boolean isExist = customerService.saveCustomer(record);

        if (isExist) {
            return ResponseEntity.ok("This is user has already exist");
        } else {
            //go to fraud service and check this customer is fraudlent
            //Do it firstly using RestTemplate object.
            /*ResponseEntity<FraudResponse> response=
                    restTemplate.getForEntity(
                            "localhost:8082/api/v1/fraud/customer/1",
                    FraudResponse.class);
            return response;}*/
            return ResponseEntity.ok(myFeignClient.getFraudResponse(1));

        }

    }
}

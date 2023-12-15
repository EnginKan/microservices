package com.yeditepe.comp301.microservices.fraud;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud")
public class FraudController {

    private final FraudService fraudService;

    //create an api endpoint
    @GetMapping("/customer/{id}")
    public ResponseEntity checkCustomer(@PathVariable("id") Integer id){
        boolean service_response = fraudService.isFraudelend(id);
        return ResponseEntity.ok(new FraudResponse(service_response));
    }


}

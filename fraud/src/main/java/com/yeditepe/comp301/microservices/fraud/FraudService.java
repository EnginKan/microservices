package com.yeditepe.comp301.microservices.fraud;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRecordRepository fraudRecordRepository;

    public  boolean isFraudelend(Integer customer_id){
        Optional<FraudRecord> record=fraudRecordRepository.findById(customer_id);
        if(record.isPresent())
            return record.get().isFraudelent();
        else{
            fraudRecordRepository.save(new FraudRecord.FraudRecordBuilder().
                    customer_id(customer_id).isFraudelent(false)
                    .build());
            return false;
        }
    }

}

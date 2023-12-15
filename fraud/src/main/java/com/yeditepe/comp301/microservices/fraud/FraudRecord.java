package com.yeditepe.comp301.microservices.fraud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FraudRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
private Integer customer_id;
private boolean isFraudelent;
}

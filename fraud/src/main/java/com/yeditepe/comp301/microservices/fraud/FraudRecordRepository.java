package com.yeditepe.comp301.microservices.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRecordRepository extends CrudRepository<FraudRecord,Integer> {

}

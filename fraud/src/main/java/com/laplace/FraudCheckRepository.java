package com.laplace;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckRepository extends MongoRepository<FraudCheckHistory, String> {
    public long count();

    public FraudCheckHistory findByCustomerId(Integer customerId);
}
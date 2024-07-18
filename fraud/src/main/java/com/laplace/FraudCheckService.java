package com.laplace;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckRepository fraudCheckRepository;
    
    public void addHistory(FraudCheckHistory fraudCheckHistory) {
        fraudCheckRepository.save(fraudCheckHistory);
    }

    public boolean isFraudulentCustomer(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory
                .builder()
                .customerId(customerId)
                .isFraudSter(false)
                .createdDate(LocalDateTime.now())
                .build();

        fraudCheckRepository.save(fraudCheckHistory);
        return false;
    }
    
}

package com.laplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class FraudCheckRunner implements CommandLineRunner{

    @Autowired
    private FraudCheckService fraudCheckService;

    @Override
    public void run(String... args) throws Exception {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().customerId(2).isFraudSter(false).build();

        fraudCheckService.addHistory(fraudCheckHistory);

        var result = fraudCheckService.isFraudulentCustomer(2);
        System.out.println(result);
    }
    
}
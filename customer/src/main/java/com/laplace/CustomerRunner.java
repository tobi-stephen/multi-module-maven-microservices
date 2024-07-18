package com.laplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class CustomerRunner implements CommandLineRunner{

    // @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        CustomerRegistrationRequest customerRegistrationRequest = 
            new CustomerRegistrationRequest("bola", "salo", "bola.salo@laplace.zen");

        customerService.registerCustomer(customerRegistrationRequest);
        
    }
    
}

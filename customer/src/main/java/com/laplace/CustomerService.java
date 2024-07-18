package com.laplace;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = 
            Customer.builder().firstName(customerRequest.firstName())
                    .lastName(customerRequest.lastName())
                    .email(customerRequest.email())
                    .build();
        customerRepository.save(customer);
      
        FraudCheckResponse fraudCheckResponse = 
            restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check/{customerId}", 
                FraudCheckResponse.class, 
                    customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudSter()) {
            throw new IllegalStateException("fraudster alert");
        }

    }

}

package com.laplace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudulentCustomer(@PathVariable("customerId") Integer customerId) {
        log.info("checking fraudster status for customer id: {}", customerId);
        return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));

    }
}

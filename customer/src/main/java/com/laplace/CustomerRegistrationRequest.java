package com.laplace;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email) {
}

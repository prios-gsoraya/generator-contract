package com.prios.api.generator.contract.api_generator_contract.exception;

public class ApiException extends RuntimeException {

    private final String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }
}

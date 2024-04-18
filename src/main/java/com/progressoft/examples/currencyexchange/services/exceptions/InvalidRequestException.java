package com.progressoft.examples.currencyexchange.services.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String field, String description) {
        super(String.format("%s: %s", field, description));
    }
}

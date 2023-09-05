package com.transactionalBank.demo.servicies.exceptions;

public class InvalidUserTypeException extends RuntimeException {
    public InvalidUserTypeException(String message) {
        super(message);
    }
}
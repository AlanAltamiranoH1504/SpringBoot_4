package com.example.springboot_4_initial.exceptions;

public class CreatedEntityException extends RuntimeException {
    public CreatedEntityException(String message) {
        super(message);
    }
}

package com.example.springboot_4_initial.exceptions.application;

public class ApplicationExistsException extends RuntimeException {
    public ApplicationExistsException(String message) {
        super(message);
    }
}

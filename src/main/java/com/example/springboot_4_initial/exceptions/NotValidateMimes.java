package com.example.springboot_4_initial.exceptions;

public class NotValidateMimes extends RuntimeException {
    public NotValidateMimes(String message) {
        super(message);
    }
}

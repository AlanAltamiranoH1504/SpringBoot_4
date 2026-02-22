package com.example.springboot_4_initial.exceptions.auth;

public class NotCofirmAccountException extends RuntimeException {
    public NotCofirmAccountException(String message) {
        super(message);
    }
}

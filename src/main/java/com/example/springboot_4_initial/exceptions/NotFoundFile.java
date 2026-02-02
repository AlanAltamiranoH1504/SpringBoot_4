package com.example.springboot_4_initial.exceptions;

public class NotFoundFile extends RuntimeException {
    public NotFoundFile(String message) {
        super(message);
    }
}

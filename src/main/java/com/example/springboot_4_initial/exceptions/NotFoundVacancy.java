package com.example.springboot_4_initial.exceptions;

public class NotFoundVacancy extends RuntimeException {
    public NotFoundVacancy(String message) {
        super(message);
    }
}

package com.example.springboot_4_initial.exceptions;

public class NotFoundVacancys extends RuntimeException {
    public NotFoundVacancys(String message) {
        super(message);
    }
}

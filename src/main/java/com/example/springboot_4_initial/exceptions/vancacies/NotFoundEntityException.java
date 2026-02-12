package com.example.springboot_4_initial.exceptions.vancacies;

public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(String message) {
        super(message);
    }
}

package com.example.springboot_4_initial.exceptions.users;

public class UpdateProfileException extends RuntimeException {
    public UpdateProfileException(String message) {
        super(message);
    }
}

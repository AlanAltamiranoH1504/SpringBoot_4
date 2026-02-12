package com.example.springboot_4_initial.exceptions.users;

public class RemoveProfileException extends RuntimeException {
    public RemoveProfileException(String message) {
        super(message);
    }
}

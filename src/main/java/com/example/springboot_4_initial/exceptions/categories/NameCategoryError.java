package com.example.springboot_4_initial.exceptions.categories;

public class NameCategoryError extends RuntimeException {
    public NameCategoryError(String message) {
        super(message);
    }
}

package com.example.springboot_4_initial.exceptions.categories;

public class NotFoundCategories extends RuntimeException {
    public NotFoundCategories(String message) {
        super(message);
    }
}

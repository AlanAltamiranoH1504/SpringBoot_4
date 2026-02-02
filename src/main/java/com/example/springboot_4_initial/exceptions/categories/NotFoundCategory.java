package com.example.springboot_4_initial.exceptions.categories;

public class NotFoundCategory extends RuntimeException {
    public NotFoundCategory(String message) {
        super(message);
    }
}

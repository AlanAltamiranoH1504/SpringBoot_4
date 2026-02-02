package com.example.springboot_4_initial.exceptions.categories;

public class CreatedCategory extends RuntimeException {
    public CreatedCategory(String message) {
        super(message);
    }
}

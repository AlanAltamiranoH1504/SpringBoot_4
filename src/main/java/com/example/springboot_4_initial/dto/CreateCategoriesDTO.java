package com.example.springboot_4_initial.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateCategoriesDTO {
    @NotEmpty(message = "El array de categorias no puede estar vacio")
    List<@Valid CreateCategoryDTO> categories;

    public List<CreateCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CreateCategoryDTO> categories) {
        this.categories = categories;
    }
}

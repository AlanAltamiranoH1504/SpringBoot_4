package com.example.springboot_4_initial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UpdateCategoryDTO {
    @NotBlank(message = "El nombre no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String name;

    @NotBlank(message = "La descripción no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String description;

    @NotNull(message = "El status es obligatorio")
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

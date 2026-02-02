package com.example.springboot_4_initial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;

public class CreateCategoryDTO {

    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String name;

    @NotNull(message = "La descripcion es obligatoria")
    @NotBlank(message = "La descripción no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String description;

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
}

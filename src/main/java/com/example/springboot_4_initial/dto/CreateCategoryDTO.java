package com.example.springboot_4_initial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;

public class CreateCategoryDTO {
    @NotNull(message = "El id es obligatorio")
    @Positive(message = "El id no puede ser un valor negativo")
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String nombre;

    @NotNull(message = "La descripcion es obligatoria")
    @NotBlank(message = "La descripción no puede ser una cadena vacia")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

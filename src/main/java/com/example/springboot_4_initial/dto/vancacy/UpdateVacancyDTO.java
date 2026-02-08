package com.example.springboot_4_initial.dto.vancacy;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class UpdateVacancyDTO {
    @NotEmpty(message = "El nombre de la vacante es requerido")
    @NotNull(message = "El nombre de la vacante es requerido")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String name;

    @NotEmpty(message = "La descrion no puede ser vacia")
    @NotNull(message = "La descripcion es requerida")
    private String description;

    @Positive(message = "El salario debe ser mayor a 0")
    private double salary;

    private String image;

    @NotNull(message = "La categoria es obligatoria")
    @Positive(message = "La categoria no es valida")
    private Long category;

    @NotNull(message = "El estado es obligatorio")
    Boolean status;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

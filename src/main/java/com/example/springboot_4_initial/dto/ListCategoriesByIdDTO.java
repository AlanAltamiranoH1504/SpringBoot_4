package com.example.springboot_4_initial.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class ListCategoriesByIdDTO {
    @NotEmpty(message = "Debe existir al menos un elemento")
    List<
            @NotNull(message = "El id es obligatorio")
            @Positive(message = "El id debe ser mayor a 0")
            Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}

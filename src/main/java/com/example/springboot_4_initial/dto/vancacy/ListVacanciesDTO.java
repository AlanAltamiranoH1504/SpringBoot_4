package com.example.springboot_4_initial.dto.vancacy;

import jakarta.validation.constraints.NotNull;

public class ListVacanciesDTO {
    @NotNull(message = "El estado es requerido (true/false)")
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

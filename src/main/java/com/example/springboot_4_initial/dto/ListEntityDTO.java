package com.example.springboot_4_initial.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ListEntityDTO {
    @NotNull(message = "El estado de listado solo puede ser true/false")
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

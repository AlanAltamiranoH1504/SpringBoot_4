package com.example.springboot_4_initial.dto.profile;

import jakarta.validation.constraints.NotNull;

public class ListProfileDTO {
    @NotNull(message = "El estado es requerido (true/false)")
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

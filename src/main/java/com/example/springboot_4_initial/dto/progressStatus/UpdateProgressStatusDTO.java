package com.example.springboot_4_initial.dto.progressStatus;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateProgressStatusDTO extends CreateProgressStatusDTO{
    @NotNull(message = "EL status es requerido (true/false)")
    private Boolean status;

    public UpdateProgressStatusDTO() {
        super();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

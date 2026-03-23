package com.example.springboot_4_initial.dto.progressStatus;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateProgressStatusDTO {
    @NotBlank(message = "EL nombre es del progreso es requerido")
    @Length(max = 100, message = "El nombre del progreso no puede tener mas de 100 caracteres")
    private String name_progress_status;

    @NotBlank(message = "La descripcion del progreso es requerida")
    @Length(max = 150, message = "La descripcion del progreso no puede tener mas de 150 caracteres")
    private String description_progress_status;

    public String getName_progress_status() {
        return name_progress_status;
    }

    public void setName_progress_status(String name_progress_status) {
        this.name_progress_status = name_progress_status;
    }

    public String getDescription_progress_status() {
        return description_progress_status;
    }

    public void setDescription_progress_status(String description_progress_status) {
        this.description_progress_status = description_progress_status;
    }
}

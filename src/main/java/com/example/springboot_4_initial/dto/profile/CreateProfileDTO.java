package com.example.springboot_4_initial.dto.profile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CreateProfileDTO {
    @NotEmpty(message = "El nombre del perfil es requerido")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}

package com.example.springboot_4_initial.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class AddProfilesDTO {
    @NotEmpty(message = "Los perfiles son requeridos")
    List<
//            @NotNull(message = "El id de los perfiles es requerido")
            @Positive(message = "El id de los perfiles debe ser un numero entero")
                    Long> profiles;

    public List<Long> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Long> profiles) {
        this.profiles = profiles;
    }
}

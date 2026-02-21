package com.example.springboot_4_initial.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginDTO {
    @NotEmpty(message = "El email es requerido")
    @NotNull(message = "El email es requerido")
    @Email(message = "El formato de email no es valido")
    private String email;

    @NotEmpty(message = "El password es requerido")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

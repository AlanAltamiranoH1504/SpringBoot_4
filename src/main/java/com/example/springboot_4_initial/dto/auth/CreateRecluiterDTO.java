package com.example.springboot_4_initial.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

public class CreateRecluiterDTO {
    // * Data tbl_user
    @NotEmpty(message = "El email del reclutador es requerido")
    @Email(message = "El formato de email no es valido")
    private String email;

    @NotEmpty(message = "El password es requerido")
    @Length(min = 8, max = 100, message = "El password debe tener minimo 8 caracteres")
    private String password;

    @NotNull(message = "El rol es necesario")
    List<
            @NotNull(message = "El id del rol es requerido")
            @Positive(message = "El id del rol debe ser un numero positvo")
                    Long> roles = new ArrayList<>();

    // * Data tbl_recluiter
    @NotEmpty(message = "El nombre del reclutador es requerido")
    @Length(max = 50, message = "El nombre del reclutador no puede ser mayor a 150 caracteres")
    private String name;

    @NotEmpty(message = "Los apellidos del reclutador son requeridos")
    @Length(max = 200, message = "Los apellidos no pueden ser mayor a 200 caracteres")
    private String surnames;

    @NotEmpty(message = "El username es requerido")
    @Length(max = 45, message = "El username no deben ser mayor a 45 caracteres")
    private String username;

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

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

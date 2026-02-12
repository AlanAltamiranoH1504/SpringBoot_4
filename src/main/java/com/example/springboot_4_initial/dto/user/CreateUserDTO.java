package com.example.springboot_4_initial.dto.user;

import jakarta.validation.constraints.*;

import java.util.List;

public class CreateUserDTO {

    @NotEmpty(message = "El nombre es requerido")
    @Size(min = 3, max = 50, message = "El nombre no debe ser mayor a 50 caracteres")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String name;

    @NotEmpty(message = "Los apellidos son requeridos")
    @Size(min = 3, max = 200, message = "Los apellidos no deben ser mayor a 200 caracteres")
    @Pattern(regexp = "^[\\p{L} ]+$", message = "Solo se admiten letras y espacios")
    private String surnames;

    @NotEmpty(message = "El email es requerido")
    @Size(max = 100, message = "Email no valido")
    @Email(message = "El formato de email no es valido")
    private String email;

    @NotEmpty(message = "El username es requerido")
    @Size(max = 45, message = "El username no debe superar los 45 caracteres")
    private String username;

    @NotEmpty(message = "El password es requerido")
    @Size(min = 8, max = 100, message = "El password debe ser de al menos 8 caracteres")
    private String password;

    private String img_profile;

    @NotEmpty(message = "Los perfiles son requeridos")
    private List<
            @NotNull(message = "El id de los perfiles es requerido")
            @Positive(message = "El id debe ser un valor entero")
                    Long> profiles;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }

    public List<Long> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Long> profiles) {
        this.profiles = profiles;
    }
}

package com.example.springboot_4_initial.dto.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CreateCandidateDTO {
    @NotEmpty(message = "El nombre del candidato es requerido")
    @NotNull(message = "El nombre del candidato es requerido")
    @Length(min = 1, max = 100, message = "El nombre no debe ser mayor a 100 caracteres")
    private String name_candidate;

    @NotEmpty(message = "Los apellidos del candidato son requeridos")
    @NotNull(message = "Los apellidos del candidato son requeridos")
    @Length(min = 1, max = 100, message = "Los apellidos del candidato no debe ser mayor a 200 caracteres")
    private String lastname_candidate;

    @NotEmpty(message = "El email es requerido")
    @Email(message = "Formato de email no valido")
    private String email;

    @NotEmpty(message = "El password es requerido")
    @Length(min = 8, max = 100, message = "La longitud del password no es valida")
    private String password;

    // * Optional fields
    private String cellphone;
    private String address;

    public String getName_candidate() {
        return name_candidate;
    }

    public void setName_candidate(String name_candidate) {
        this.name_candidate = name_candidate;
    }

    public String getLastname_candidate() {
        return lastname_candidate;
    }

    public void setLastname_candidate(String lastname_candidate) {
        this.lastname_candidate = lastname_candidate;
    }

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

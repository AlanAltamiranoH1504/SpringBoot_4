package com.example.springboot_4_initial.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class CreateCandidateDTO {
    // * Data tbl_user
    @NotEmpty(message = "El email del candidato es requerido")
    @Email(message = "El formato de email no es valido")
    private String email;

    @NotEmpty(message = "El password es requerido")
    @Length(min = 8, max = 100, message = "El password debe tener minimo 8 caracteres")
    private String password;

    @NotNull(message = "El rol es necesario")
    List<
            @NotNull(message = "El id del rol es requerido")
            @Positive(message = "El id del rol debe ser un numero positvo")
                    Long> roles;

    // * Data tbl_recluiter
    @NotEmpty(message = "El nombre del candidato es requerido")
    @Length(max = 50, message = "El nombre del candidate no puede ser mayor a 150 caracteres")
    private String name_candidate;

    @NotEmpty(message = "Los apellidos del candidato son requeridos")
    @Length(max = 200, message = "Los apellidos no pueden ser mayor a 200 caracteres")
    private String lastname_candidate;

    @NotEmpty(message = "El número de contacto es requerido")
    @Length(max = 20, message = "El telefono no puede tener mas de 20 caracteres")
    private String cellphone;

    @NotEmpty(message = "La direccion es requerida")
    @Length(max = 300, message = "La direccion no debe ser mayor a 300 caracteres")
    private String address;

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

    public List<


            Long> getRoles() {
        return roles;
    }

    public void setRoles(List<


            Long> roles) {
        this.roles = roles;
    }

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

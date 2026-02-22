package com.example.springboot_4_initial.dto.auth;

import jakarta.validation.constraints.NotEmpty;

public class ConfirmAccountDTO {
    @NotEmpty(message = "El token de confirmacion es obligatorio")
    String token_confirm_account;
    @NotEmpty(message = "Los 5 digitos de confirmación sob obligatorios")
    String randome_number;

    public String getToken_confirm_account() {
        return token_confirm_account;
    }

    public void setToken_confirm_account(String token_confirm_account) {
        this.token_confirm_account = token_confirm_account;
    }

    public String getRandome_number() {
        return randome_number;
    }

    public void setRandome_number(String randome_number) {
        this.randome_number = randome_number;
    }
}

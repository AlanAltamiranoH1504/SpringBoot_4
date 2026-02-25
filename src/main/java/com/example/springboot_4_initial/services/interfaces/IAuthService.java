package com.example.springboot_4_initial.services.interfaces;

public interface IAuthService {
    public abstract String login_user(String email, String password);
    public abstract boolean confirm_candidate_account(String token, String randome_number);
}

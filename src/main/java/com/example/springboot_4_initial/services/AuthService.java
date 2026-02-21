package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.auth.PasswordIncorrectException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.security.JwtService;
import com.example.springboot_4_initial.services.interfaces.IAuthService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login_user(String email, String password) {
        // * Search user
        Optional<User> user_by_email = iUserService.get_user_by_email(email);

        if (user_by_email.isEmpty()) {
            throw new NotFoundEntityException("El usuario a buscar no esta registrado");
        }
        if (passwordEncoder.matches(password, user_by_email.get().getPassword())) {
            return jwtService.generateTokenJWT(user_by_email.get());
        }
        throw new PasswordIncorrectException("El password es incorrecto");
    }
}

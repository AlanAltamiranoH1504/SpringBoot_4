package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.auth.NotCofirmAccountException;
import com.example.springboot_4_initial.exceptions.auth.PasswordIncorrectException;
import com.example.springboot_4_initial.exceptions.vancacies.NotFoundEntityException;
import com.example.springboot_4_initial.models.Candidate;
import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.security.JwtService;
import com.example.springboot_4_initial.services.interfaces.IAuthService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.*;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;

    @Override
    public String login_user(String email, String password) {
        // * Search user
        Optional<User> user_by_email = iUserService.get_user_by_email(email);
        if (user_by_email.isEmpty()) {
            throw new NotFoundEntityException("El usuario a buscar no esta registrado");
        }
        if (user_by_email.get().getRandome_number() != null && user_by_email.get().getToken_confirm_account() != null) {
            User user = user_by_email.get();
            iUserService.save_user(user);
            throw new NotCofirmAccountException("El usuario no ha confirmado su cuenta de manera correcta. Verifica tu correo para confirmación");
        }
        if (passwordEncoder.matches(password, user_by_email.get().getPassword())) {
            return jwtService.generateTokenJWT(user_by_email.get());
        }
        throw new PasswordIncorrectException("El password es incorrecto");
    }
}

package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.dto.auth.ConfirmAccountDTO;
import com.example.springboot_4_initial.dto.auth.ConfirmCandidateDTO;
import com.example.springboot_4_initial.dto.auth.LoginDTO;
import com.example.springboot_4_initial.services.interfaces.IAuthService;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService iAuthService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login_user(@Valid @RequestBody LoginDTO loginDTO) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("token", iAuthService.login_user(loginDTO.getEmail(), loginDTO.getPassword()));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/confirm_account")
    public ResponseEntity<?> confirm_account(@Valid @RequestBody ConfirmAccountDTO confirmAccountDTO) {
        Map<String, Object> json = new HashMap<>();

        iUserService.confirm_account(confirmAccountDTO.getToken_confirm_account(), confirmAccountDTO.getRandome_number());
        json.put("status", true);
        json.put("message", "Usuario confirmado correctamente");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}

package com.example.springboot_4_initial.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
    public UserInfoDetails user_in_sesion() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof UserInfoDetails)) {
            return null;
        }
        return (UserInfoDetails) authentication.getPrincipal();
    }
}

package com.example.springboot_4_initial.security;

import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user_to_found = iUserService.get_user_by_email(email);

        return user_to_found.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + " no encontrado"));
    }
}

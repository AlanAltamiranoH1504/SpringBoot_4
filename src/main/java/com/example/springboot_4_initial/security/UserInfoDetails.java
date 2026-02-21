package com.example.springboot_4_initial.security;

import com.example.springboot_4_initial.models.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Long id_user;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(User user) {
        this.username = user.getName();
        this.password = user.getPassword();
        this.id_user = user.getId();
        this.authorities = Arrays.stream(user.getName().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Long get_IdUser() {
        return this.id_user;
    }
}

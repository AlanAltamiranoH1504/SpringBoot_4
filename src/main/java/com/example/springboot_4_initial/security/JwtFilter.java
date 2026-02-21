package com.example.springboot_4_initial.security;

import com.example.springboot_4_initial.models.User;
import com.example.springboot_4_initial.services.interfaces.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerAuth = request.getHeader("Authorization");
        String token = null;
        String email = null;

        // * Token existente y no corrupto
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            token = headerAuth.substring(7);
            email = jwtService.extract_email(token);
        }

        // * Validacion de email en claims
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<User> user = iUserService.get_user_by_email(email);
            if (jwtService.is_token_valid(token, user.get())) {
                var authorities = user.get().getProfiles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getProfile()))
                        .toList();
                UserInfoDetails user_details = new UserInfoDetails(user.get());

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user_details, null, authorities);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}

package com.myschool.backend.security;

import com.myschool.backend.entity.User;
import com.myschool.backend.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtSecurity jwtSecurity;
    private final UserRepository userRepository;

    public JwtAuthFilter(
            JwtSecurity jwtSecurity,
            UserRepository userRepository
    ) {
        this.jwtSecurity = jwtSecurity;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {

            String loginId = jwtSecurity.extractLoginId(token);

            if (loginId != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                User user = userRepository
                        .findByLoginId(loginId)
                        .orElse(null);

                if (user != null && jwtSecurity.isTokenValid(token, user)) {

                    List<GrantedAuthority> authorities =
                            List.of(
                                    new SimpleGrantedAuthority(
                                            "ROLE_" + user.getRole().name()
                                    )
                            );

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    authorities
                            );

                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(authentication);
                }
            }

        } catch (Exception e) {
            // Invalid or expired token.
            // Request remains unauthenticated.
        }

        filterChain.doFilter(request, response);
    }
}
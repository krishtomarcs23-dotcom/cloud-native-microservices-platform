package com.krish.cloud.customer.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    // ✅ Inject JwtFilter (Spring creates it with JwtUtil)
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        // 🔴 REQUIRED for H2
        .csrf(csrf -> csrf.disable())
        .headers(headers -> headers.frameOptions(frame -> frame.disable()))

        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/",                    // optional home
                "/customers/login",     // login
                "/h2-console/**"        // ✅ H2 console
            ).permitAll()
            .anyRequest().authenticated()
        )
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
}
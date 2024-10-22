package com.prueba.springsecurity.config;

import com.prueba.springsecurity.repository.UserRepository;
import com.prueba.springsecurity.service.imp.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeanConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new CustomUserDetailsService(userRepository, passwordEncoder);
    }
}

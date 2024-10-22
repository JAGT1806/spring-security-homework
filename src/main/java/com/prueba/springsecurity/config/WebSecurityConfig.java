package com.prueba.springsecurity.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
// @EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@AllArgsConstructor
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
                        .requestMatchers("/new/**").hasAnyAuthority("ADMIN", "CREATOR")
                        .requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
                        .requestMatchers("/delete/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authentication")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling((exceptions) -> exceptions.accessDeniedPage("/403")
                );

        return http.build();
    }
}
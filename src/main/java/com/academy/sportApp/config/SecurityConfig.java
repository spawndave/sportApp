package com.academy.sportApp.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http.authorizeHttpRequests(authorize ->{
           authorize
                   .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                   .requestMatchers(HttpMethod.GET,"/login").permitAll()
                   .requestMatchers(HttpMethod.GET,"/fragments/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/registration").permitAll()
                    .requestMatchers(HttpMethod.GET, "/registration").permitAll()
                   .anyRequest().authenticated();
        }).formLogin(
                form -> form.defaultSuccessUrl("/sport")
                        .loginPage("/login")
                        .permitAll()
        ).csrf(AbstractHttpConfigurer::disable)
                .authenticationManager(authenticationManager);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
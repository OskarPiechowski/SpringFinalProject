package com.example.springfinalproject.config;

import com.example.springfinalproject.service.OrganisationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity
public class Security {
    private OrganisationService organisationService;

    private PasswordEncoder passwordEncoder;

    public Security(OrganisationService organisationService, PasswordEncoder passwordEncoder) {
        this.organisationService = organisationService;
        this.passwordEncoder = passwordEncoder;
    }
//
//    public Security(OrganisationService organisationService) {
//        this.organisationService = organisationService;
//    }
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration configuration) throws Exception{
//        return configuration.getAuthenticationManager();
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
//                .headers().disable() //for console
//                .authorizeHttpRequests((authorize) ->
//                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                                .requestMatchers("/console").permitAll()
//                        .requestMatchers("/api/authorisation/**").permitAll()
//                                .anyRequest().permitAll())
//                .formLogin();
//        return httpSecurity.build();
//    }
}

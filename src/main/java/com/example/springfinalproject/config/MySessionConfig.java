package com.example.springfinalproject.config;

import com.example.springfinalproject.session.OrganisationSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class MySessionConfig {

    @Bean
    @SessionScope
    public OrganisationSession mySession(){
        System.out.println("new session start!");
        return new OrganisationSession();
    }
}

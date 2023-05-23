package com.example.springfinalproject.service;

import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.repository.OrganisationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private OrganisationRepository organisationRepository;

    public AuthenticationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public Organisation selectLoggedOrganisation() {
        Object securityContextHolder = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (securityContextHolder instanceof User) {
            User user = (User) securityContextHolder;
            Organisation organisation = organisationRepository.findByName(user.getUsername()).orElseThrow(() -> new NullPointerException("Nie ma takiego użytkownika"));
            return organisation;
        } else {
            return null;
        }

    }
}

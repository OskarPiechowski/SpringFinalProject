package com.example.springfinalproject.service;

import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.repository.OrganisationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private OrganisationRepository organisationRepository;

    public AuthenticationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public Optional<Organisation> selectLoggedOrganisation() {
        Object securityContextHolder = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (securityContextHolder instanceof User) {
            User user = (User) securityContextHolder;
            Optional <Organisation> loggedOrganisation = organisationRepository.findByName(user.getUsername());
//            Organisation organisation = organisationRepository.findByName(user.getUsername()).orElseThrow(() -> new NullPointerException("Provided Organisation does not exist"));
            return loggedOrganisation;
        } else {
            return Optional.empty();
        }

    }
}

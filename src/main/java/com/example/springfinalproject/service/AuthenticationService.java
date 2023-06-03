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
            return loggedOrganisation;
        } else {
            return Optional.empty();
        }
    }
    /*tą metodę można fajnie skrócić robiąc onelinera i przerzucając user do warunku
    póki co zostawiam w takiej formie jak jest, bo wydaje mi się dużo bardziej logiczna
    zmieniłem typ zwracany metody z Organisation na Optional, zgodnie z sugesitą Daniela
     */
}

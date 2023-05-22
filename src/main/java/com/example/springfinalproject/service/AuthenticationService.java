package com.example.springfinalproject.service;

import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.repository.OrganisationRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private OrganisationRepository organisationRepository;

    public AuthenticationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public void selectLogged(Object object){
        User user = (User) object;
        Organisation organisation = organisationRepository.findByName(user.getUsername()).orElseThrow(()->new NullPointerException("Nie ma takiego użytkownika"));
        System.out.println(organisation);
    }


}

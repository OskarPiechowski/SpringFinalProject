package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.OrganisationEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrganisationService {
    public void addOrganisation(OrganisationDto request) {
        System.out.println("Dodajemy Organizację do bazy");
    }

}

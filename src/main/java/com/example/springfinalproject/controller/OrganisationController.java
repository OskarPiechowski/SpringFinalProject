package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.service.OrganisationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationController {

    private OrganisationService organisationService;
    @PostMapping("/api/organisations")
    public void addOrganisation(OrganisationDto request) {
        organisationService.addOrganisation(request);
    }
    @GetMapping("/api/organisations/{id}")
    public OrganisationDto findOrganisationById(@PathVariable long id) {
        return organisationService.findOrganisationById(id);
    }
    @GetMapping("/api/organisations/{nip}")
    public OrganisationDto findOrganisationByNip(@PathVariable int nip){
        return organisationService.findOrganisationByNip(nip);
    }
    @GetMapping("/api/organisations/")
    public List<OrganisationDto> getOrganisationByCity(String city){
        if(city == null){
return organisationService.getOrganisations();
        }
        return organisationService.getOrganisationsByCity(city);
    }
}

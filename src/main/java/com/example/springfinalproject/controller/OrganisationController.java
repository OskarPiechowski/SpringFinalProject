package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.service.OrganisationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class OrganisationController {

    private OrganisationService organisationService;
    @PostMapping("/organisations")
    public void addOrganisation(OrganisationDto request) {
        organisationService.addOrganisation(request);
    }
    @GetMapping("/organisations/{id}")
    public OrganisationDto findOrganisationById(@PathVariable long id) {
        return organisationService.findOrganisationById(id);
    }
    @GetMapping("/organisations/{nip}")
    public OrganisationDto findOrganisationByNip(@PathVariable int nip){
        return organisationService.findOrganisationByNip(nip);
    }
    @GetMapping("/organisations/")
    public List<OrganisationDto> getOrganisationByCity(String city){
        if(city == null){
return organisationService.getOrganisations();
        }
        return organisationService.getOrganisationsByCity(city);
    }
}

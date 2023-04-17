package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.service.OrganisationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganisationController {

    private OrganisationService organisationService;
    @PostMapping("/api/organisations")
    public void addOrganisation(OrganisationDto request) {
        organisationService.addOrganisation(request);
    }

//    @DeleteMapping("/api/organisation/delete")
//    public ResponseEntity<ApiResponse> deleteOrganisation(@PathVariable("organisation_id") int organisationId) {
//        return new ResponseEntity<ApiResponse>(true, "organisation deleted");
//    }

    @GetMapping("/api/organisations/{id}")
    public OrganisationDto findOrganisationById(@PathVariable long id) {
        return organisationService.findOrganisationById(id);
    }
    @GetMapping("/api/organisations/{nip}")
    public OrganisationDto findOrganisationByNip(@PathVariable int nip){
        return organisationService.findOrganisationByNip(nip);
    }
    @GetMapping("/api/organisations/{city}")
    public OrganisationDto findOrganisationByCity(@PathVariable String city){
        return organisationService.findOrganisationByCity(city);
    }
}

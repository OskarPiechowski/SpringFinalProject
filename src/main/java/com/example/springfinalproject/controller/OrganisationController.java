package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganisationController {
    @PostMapping("/api/organisations")
    public void addOrganisation(OrganisationDto request) {
        organisationServie.addOrganisation(request);
    }

    @DeleteMapping("/api/organisation/delete")
    public ResponseEntity<ApiResponse> deleteOrganisation(@PathVariable("organisation_id") int organisationId) {
        return new ResponseEntity<ApiResponse>(true, "organisation deleted");
    }

    @GetMapping("/api/organisation")
    public OrganisationDto getOrganisation() {
        return new OrganisationDto();
    }
}

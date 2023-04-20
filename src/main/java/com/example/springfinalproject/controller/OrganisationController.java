package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
@AllArgsConstructor
public class OrganisationController {

    private OrganisationService organisationService;

    @PostMapping("/organisations")
    public void addOrganisation(@RequestBody OrganisationDto request) {
        organisationService.addOrganisation(request);
    }
    @DeleteMapping("organisations/delete/{id}")
    public ResponseEntity<String> deleteOrganisation(@PathVariable Long id){
        organisationService.deleteOrganisation(id);
        return ResponseEntity.ok("your id account: " + id + " has been deleted.");
    }
    @PutMapping("/organisations/update/{id}")
    public ResponseEntity<String> updateOrganisation(@PathVariable Long id, String name){
        organisationService.updateOrganisation(id, name);
        return ResponseEntity.ok("You account has been updated with new value: "  + name);
    }
    @GetMapping("/organisations/{id}")
    public OrganisationDto findOrganisationById(@PathVariable long id) {
        return organisationService.findOrganisationById(id);
    }
    @GetMapping("/organisations/nip")
    public ResponseEntity<List<OrganisationDto>> findOrganisationByNip(@RequestParam String nip){
        return ResponseEntity.ok().body(organisationService.findOrganisationByNip(nip));
    }
    @GetMapping("/organisations/")
    public List<OrganisationDto> getOrganisationByCity(String city){
        if(city == null){
            return organisationService.getOrganisations();
        }
        return organisationService.getOrganisationsByCity(city);
    }
}

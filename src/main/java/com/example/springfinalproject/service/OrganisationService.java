package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.mapper.OrganisationMapper;
import com.example.springfinalproject.repository.OrganisationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrganisationService {

    private OrganisationMapper organisationMapper;
    private final OrganisationRepository organisationRepository;

    public OrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public void addOrganisation(OrganisationDto dto) {
        Organisation organisation = organisationMapper.mapToEntity(dto);
                organisationRepository.save(organisation);
    }
    public OrganisationDto findOrganisationById(long id){
Organisation organisation =organisationRepository.findById(id)
        .orElseThrow();
return organisationMapper.mapToDto(organisation);
    }

    public OrganisationDto findOrganisationByNip(long nip) {
        Organisation organisation = organisationRepository.findByNip(nip);
        return organisationMapper.mapToDto(organisation);
    }
    public OrganisationDto findOrganisationByCity(String city){
        Organisation organisation = organisationRepository.findByCity(city);
        return organisationMapper.mapToDto(organisation);
    }
}

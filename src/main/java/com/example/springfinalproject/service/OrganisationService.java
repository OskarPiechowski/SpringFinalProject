package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.mapper.OrganisationMapper;
import com.example.springfinalproject.repository.OrganisationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrganisationService implements UserDetailsService {
    private OrganisationMapper organisationMapper;
    private final OrganisationRepository organisationRepository;

    public void addOrganisation(OrganisationDto dto) {
        Organisation organisation = organisationMapper.mapToEntity(dto);
        organisationRepository.save(organisation);
    }
    public void deleteOrganisation(Long id){
        Organisation organisation = organisationRepository.findById(id)
                .orElseThrow();
        organisationRepository.delete(organisation);
    }
    public void updateOrganisation(Long id, String name){
        Organisation organisation = organisationRepository.findById(id).orElseThrow();
        organisation.setName(name);
        organisationRepository.save(organisation);
    }
    public OrganisationDto findOrganisationById(long id){
        Organisation organisation =organisationRepository.findById(id)
                .orElseThrow();
        return organisationMapper.mapToDto(organisation);
    }

    public List<OrganisationDto> findOrganisationByNip(long nip) {
        List<OrganisationDto> organisationDtos = new ArrayList<>();
        List<Organisation> organisations = organisationRepository.findByNip(nip);
        for (Organisation organisation : organisations) {
            organisationDtos.add(organisationMapper.mapToDto(organisation));
        }
        return organisationDtos;
    }

    public List<OrganisationDto> getOrganisationsByCity(String city){
        List<Organisation> organisations = organisationRepository.findByCity(city);
        return organisationMapper.mapToDtos(organisations);
    }
    public List<OrganisationDto> getOrganisations(){
        List<Organisation> organisations = organisationRepository.findAll();
        return organisationMapper.mapToDtos(organisations);
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
      /*  Organisation organisation = organisationRepository.findByNameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("Organisation not found with organisation name or email: " + usernameOrEmail));
                Set<GrantedAuthority> authorities = organisation
                        //.getRoles()
                        .stream()
                        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(organisation.getEmail(),
        organisation.getLoginPassword(),
        authorities);*/
        return null;
    }
}

package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.Organisation;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class OrganisationMapper {

public List<OrganisationDto> mapToDtos(List<Organisation> organisations){
    return organisations.stream()
            .map(p -> mapToDto(p))
            .toList();
}


public List<Organisation> mapToEntities(List<OrganisationDto> organisationDtos){
    return organisationDtos.stream()
            .map(p -> mapToEntity(p))
            .toList();
}

public OrganisationDto mapToDto(Organisation organisation){
return OrganisationDto.builder()
        .id(organisation.getId())
        .name(organisation.getName())
        .address(organisation.getAddress())
        .postcode(organisation.getPostcode())
        .city(organisation.getCity())
        .build();
}
public Organisation mapToEntity(OrganisationDto organisationDto){
return new Organisation(organisationDto.getName(), organisationDto.getNip(), organisationDto.getAddress(), organisationDto.getCity(), organisationDto.getPostcode());

}
}
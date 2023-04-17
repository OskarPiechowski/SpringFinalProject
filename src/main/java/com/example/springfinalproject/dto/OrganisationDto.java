package com.example.springfinalproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrganisationDto {

    private Long id;
    private String name;
    private String address;
    private long nip;

    private String city;

    private int postcode;

}

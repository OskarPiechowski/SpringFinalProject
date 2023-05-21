package com.example.springfinalproject.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDto {

    private Long id;
    //Poniższe ustawione zgodnie z entity:
    //zapewnienie rozmiaru od 2 do 20 znaków, oba włącznie oraz to, że atrybut/pole ma mieć unikalną wartość;
    // przez to nadaje się również na id, ale nic z tym nie robię; należy dodatkowo pamiętać, żeby w warstwie logiki aplikacji, również to sprawdzać
    @Column(unique = true)
    @Size(min = 2, max = 20)
    private String name;
    private String email;
    private String loginPassword;
    private String nip;
    private String address;
    private String city;
    private String postcode;

}

package com.example.springfinalproject.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private Long id;
    //Poniższe ustawione zgodnie z entity:
    //zapewnienie rozmiaru od 2 do 20 znaków, oba włącznie oraz to, że atrybut/pole ma mieć unikalną wartość;
    // przez to nadaje się również na id, ale nic z tym nie robię; należy dodatkowo pamiętać, żeby w warstwie logiki aplikacji, również to sprawdzać
//    @Column(unique = true)
//    @Size(min = 2, max = 20)
    private String name;
    private String email;
    private String loginPassword;
    private String nip;
    private String address;
    private String city;
    private String postcode;

}
//
//    //Uzgadniam z entity
//    //zapewnienie rozmiaru od 2 do 20 znaków, oba włącznie oraz to, że atrybut/pole ma mieć unikalną wartość;
//    // przez to nadaje się również na id, ale nic z tym nie robię; należy dodatkowo pamiętać, żeby w warstwie logiki aplikacji, również to sprawdzać
//    @Column(unique = true)
//    @Size(min = 2, max = 20)
//    private String name;
//
//    //Uzgadniam tym z entity
//    //Zmiana na String wg sugestii Daniela o zapisie 0 z przodu, gdyby było trzeba.
//    // Jeżeli do celów przetwarzania w systemie informatycznym wymagane jest 12 cyfr, numer NIP powinien zaczynać się od liczby 16.
//    @Pattern(regexp = "^16\\d{10}$")
//    private String nip;
//    //Uzgadniam z entity
//    @Email
//    private String email;
//
//    private String loginPassword;
//}

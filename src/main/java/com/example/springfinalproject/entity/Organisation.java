package com.example.springfinalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "organisation", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"email"})
})
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties("reservationList")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //zapewnienie rozmiaru od 2 do 20 znaków, oba włącznie oraz to, że atrybut/pole ma mieć unikalną wartość;
    // przez to nadaje się również na id, ale nic z tym nie robię; należy dodatkowo pamiętać, żeby w warstwie logiki aplikacji, również to sprawdzać
//    @Column(unique = true)
//    @Size(min = 2, max = 20)
    private String name;
//    @Email
    private String email;
    private String loginPassword;
    //Zmiana na String wg sugestii Daniela o zapisie 0 z przodu, gdyby było trzeba.
    // Jeżeli do celów przetwarzania w systemie informatycznym wymagane jest 12 cyfr, numer NIP powinien zaczynać się od liczby 16.
//    @Pattern(regexp = "^16\\d{10}$")
    private String nip;
    private String address;
    private String city;
    // Zmiana na String zgodnie z sugestią Daniela. Długość 5 dowolnych cyfr
//    @Pattern(regexp = "\\d{5}")
    private String postcode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "organisation_roles",
    joinColumns = @JoinColumn(name = "organisation_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.EAGER)
    private List<RoomReservation> reservationList = new ArrayList<>();

//    @JsonBackReference
//    @OneToMany(mappedBy = "organisation", fetch = FetchType.EAGER)
//    private List<Authorisation> authorisationList = new ArrayList<>();


    //wydaje mi się, że konstruktor z id nie powinien istnieć, bo id jest generowane, ale to moja uwaga tylko (TW); może Spring sobie z tym poradzi i tak
    public Organisation(Long id, String name, String email, String loginPassword, String nip, String address, String city, String postcode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loginPassword = loginPassword;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    public Organisation(String name, String nip, String address, String city, String postcode) {
        this.name = name;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }
}

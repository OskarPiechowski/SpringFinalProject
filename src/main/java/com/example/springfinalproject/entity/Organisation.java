package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@Builder
@EqualsAndHashCode
public class Organisation {

    public Organisation(Long id, String name, String mail, String loginPassword, long nip, String address, String city, int postcode) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.loginPassword = loginPassword;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    public Organisation(String name, long nip, String address, String city, int postcode) {
        this.name = name;
        this.nip = nip;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String mail;

    private String loginPassword;
    private long nip;
    private String address;

    private String city;

    private int postcode;
}

package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "organisations")
@Builder
@EqualsAndHashCode
public class Organisation {

    public Organisation(Long id, String name, long nip, String address, String city, int postcode) {
        this.id = id;
        this.name = name;
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
    private long nip;
    private String address;

    private String city;

    private int postcode;
}

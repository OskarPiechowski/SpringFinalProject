package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "organisations")
@Builder
@EqualsAndHashCode
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long nip;
    private String address;
    private String city;
    private int postcode;
    private boolean isOrganisationActive;

    @OneToMany(mappedBy = "additional_equipment_reservation", fetch = FetchType.EAGER)
    private List<AdditionalEquipmentReservation> equipmentReservationList = new ArrayList<>();

    @OneToMany(mappedBy = "room_reservation", fetch = FetchType.EAGER)
    private List<RoomReservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "authorisation", fetch = FetchType.EAGER)
    private List<Authorisation> authorisationList = new ArrayList<>();

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

}

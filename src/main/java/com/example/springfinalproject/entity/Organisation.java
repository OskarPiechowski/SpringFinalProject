package com.example.springfinalproject.entity;

import jakarta.persistence.*;
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
public class Organisation {


    public Organisation(Long id, String name, String email, String loginPassword, long nip, String address, String city, int postcode) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    private String email;

    private String loginPassword;
    private long nip;
    private String address;

    private String city;

    private int postcode;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "organisation_roles",
    joinColumns = @JoinColumn(name = "organisation_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "additional_equipment_reservation", fetch = FetchType.EAGER)
    private List<AdditionalEquipmentReservation> equipmentReservationList = new ArrayList<>();

    @OneToMany(mappedBy = "room_reservation", fetch = FetchType.EAGER)
    private List<RoomReservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "authorisation", fetch = FetchType.EAGER)
    private List<Authorisation> authorisationList = new ArrayList<>();
}

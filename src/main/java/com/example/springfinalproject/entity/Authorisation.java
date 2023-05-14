package com.example.springfinalproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authorisations")
@Builder
@EqualsAndHashCode
public class Authorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "organisation_id")
//    private Organisation organisation;

    @Column(unique = true)
    private String login;

    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "time_of_creation")
    private Instant timeOfCreation;

    @Column(name = "time_of_deactivation")
    private Instant timeOfDeactivation;

//    public Authorisation(Organisation organisation, String login, String password,
//                         boolean isActive, Instant timeOfCreation, Instant timeOfDeactivation) {
//        this.organisation = organisation;
//        this.login = login;
//        this.password = password;
//        this.isActive = isActive;
//        this.timeOfCreation = timeOfCreation;
//        this.timeOfDeactivation = timeOfDeactivation;
//    }
}

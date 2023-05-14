package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "conference_rooms")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String floor;
    private boolean availability;
    private int sits;
    private int bench;
    private int projector;
    // TODO zmienić nazwę pola
    private String pictureFile;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "roomId", fetch = FetchType.EAGER)
    private List<RoomReservation> roomReservationList = new ArrayList<>();

}

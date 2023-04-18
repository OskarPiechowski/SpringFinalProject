package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String floor;
    private boolean availability;
    private int sits;
    private int whiteboard;
    private int standingPlace;
    private int bed;
    private int projector;
    //TODO zmienić nazwę pola
    private int zaslepka;
    private boolean isRoomForRenting;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
}

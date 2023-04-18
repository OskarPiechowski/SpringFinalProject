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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String floor;
    private boolean availability;
    private int sits;
//    @Column(name = "tables")
    private int table;
//    @Column(name = "standing_places")
    private int standingPlace;
//    @Column(name = "beds")
    private int bed;
//    @Column(name = "projectors")
    private int projector;
    private int schema;
    private boolean isRoomForRenting;
//    @Column(name = "price_per_hour")
    private BigDecimal pricePerHour;
//    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;
}

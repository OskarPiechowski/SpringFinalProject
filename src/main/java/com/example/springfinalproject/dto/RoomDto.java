package com.example.springfinalproject.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RoomDto {

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

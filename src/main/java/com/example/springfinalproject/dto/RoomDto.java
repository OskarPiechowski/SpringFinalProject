package com.example.springfinalproject.dto;

import jakarta.persistence.Column;
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
        private int table;

        private int standingPlace;

        private int bed;

        private int projector;
        private int schema;
        private boolean isRoomForRenting;
        private BigDecimal pricePerHour;

        private BigDecimal pricePerDay;
}

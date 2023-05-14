package com.example.springfinalproject.dto;

import com.example.springfinalproject.entity.RoomReservation;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ConferenceRoomDto {

        private Long id;
        private String name;
        private String floor;
        private boolean availability;
        private int sits;
        private int whiteboard;
        private int standingPlace;
        private int bed;
        private int projector;
        private byte[] view;
        private boolean isRoomForRenting;
        private BigDecimal pricePerHour;
        private BigDecimal pricePerDay;

        private List<RoomReservation> roomReservationList = new ArrayList<>();
}

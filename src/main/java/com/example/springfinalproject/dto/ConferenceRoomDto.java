package com.example.springfinalproject.dto;

import com.example.springfinalproject.entity.RoomReservation;
import jakarta.persistence.*;
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
        private int bench;
        private int projector;
        private String pictureFile;
        private BigDecimal pricePerHour;
        private BigDecimal pricePerDay;
        private List<RoomReservation> roomReservationList = new ArrayList<>();

}

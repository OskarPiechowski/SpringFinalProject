package com.example.springfinalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoomDto {

        private Long id;
        private String name;
        private String floor;
        private boolean availability;
        private int sittingPlace;
        private int standingPlace;
        private int roomNumber;

}

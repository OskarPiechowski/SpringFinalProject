package com.example.springfinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomDto {

        private Long id;
        private String name;
        private String floor;
        private boolean availability;
        private int sittingPlace;
        private int standingPlace;
        private int lyingPlace;
}

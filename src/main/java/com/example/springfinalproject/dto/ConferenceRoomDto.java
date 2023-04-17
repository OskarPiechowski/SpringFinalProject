package com.example.springfinalproject.dto;

import lombok.*;

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
        private int sittingPlace;
        private int standingPlace;
        private int roomNumber;

}

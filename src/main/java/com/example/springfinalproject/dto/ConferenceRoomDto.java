package com.example.springfinalproject.dto;

import com.example.springfinalproject.entity.AdditionalEquipment;
import com.example.springfinalproject.entity.RoomReservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.lang.Nullable;

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
        //min 2 znaki, maks 20 znaków, nie może zawierać samych białych znaków -> ustawiam to zgodnie z entity, choć nie wiadomo czy trzeba
        @NotBlank
        @Size(min = 2, max = 20)
        private String name;
        // liczba od 0 do 10 -> ustawiam zgodnie z entity, choć nie wiadomo, czy jest to wymagane
        @Min(0)
        @Max(10)
        private int floor;
        private boolean availability;
        //wszystkie poniższe pola miejsc wymagane w projekcie
        private int sits;
        private int standingSits;
        //    pola z @Nullable są opcjonalne
        @Nullable
        private int layingSits;
        @Nullable
        private int hangingSits;
/*
        idzie do wyposażenia dodatkowego
        private int projector;
*/
        private AdditionalEquipment additionalEquipment;
        private String pictureFile;
        private BigDecimal pricePerHour;
        private BigDecimal pricePerDay;
        private List<RoomReservation> roomReservationList = new ArrayList<>();
}

package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "conference_rooms")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //min 2 znaki, maks 20 znaków, nie może zawierać samych białych znaków -> potrzebny import import jakarta.validation.constraints.Size; i nowe dependency
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    // liczba od 0 do 10 -> potrzebny import import jakarta.validation.constraints. ... (Max, Min);
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
        // TODO zmienić nazwę pola
    */
    @OneToOne
    @JoinColumn(name = "id_additional_equipment")
    public AdditionalEquipment additionalEquipment;
    @Nullable
    private String pictureFile;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "roomId", fetch = FetchType.EAGER)
    private List<RoomReservation> roomReservationList = new ArrayList<>();
}

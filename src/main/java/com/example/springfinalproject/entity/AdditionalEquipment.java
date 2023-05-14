package com.example.springfinalproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_equipment")
@Builder
@EqualsAndHashCode
public class AdditionalEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int amount;

    //TODO jakiś picture ???

    @Column(name = "price_per_hour")
    private BigDecimal pricePerHour;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;

    @OneToMany(mappedBy = "additionalEquipment", fetch = FetchType.EAGER)
    private List<AdditionalEquipmentReservation> equipmentReservationList = new ArrayList<>();

//    public AdditionalEquipment(String name, int amount, BigDecimal pricePerHour, BigDecimal pricePerDay,
//                               List<AdditionalEquipmentReservation> equipmentReservationList) {
//        this.name = name;
//        this.amount = amount;
//        this.pricePerHour = pricePerHour;
//        this.pricePerDay = pricePerDay;
//        this.equipmentReservationList = equipmentReservationList;
//    }
}

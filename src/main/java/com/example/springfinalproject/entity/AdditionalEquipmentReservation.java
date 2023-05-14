package com.example.springfinalproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_equipment_reservations")
@Builder
@EqualsAndHashCode
public class AdditionalEquipmentReservation {

    // komentarz
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // TODO konstruktory

    @ManyToOne
    @JoinColumn(name = "room_reservation_id")
    private RoomReservation roomReservation;

    @ManyToOne
    @JoinColumn(name = "additional_equipment_id")
    private AdditionalEquipment additionalEquipment;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "end_time")
    private Time endTime;

    public AdditionalEquipmentReservation(RoomReservation roomReservation, AdditionalEquipment additionalEquipment,
                                          Organisation organisation, Date startDate, Time startTime, Date endDate, Time endTime) {
        this.roomReservation = roomReservation;
        this.additionalEquipment = additionalEquipment;
        this.organisation = organisation;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }
}

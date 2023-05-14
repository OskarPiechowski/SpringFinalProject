package com.example.springfinalproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "room_reservations")
@Builder
@EqualsAndHashCode
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "organisation_id")
//    private Organisation organisation;
//
//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    private ConferenceRoom roomId;
//
//    @OneToMany(mappedBy = "additional_equipment_reservation", fetch = FetchType.EAGER)
//    private List<AdditionalEquipmentReservation> additionalEquipmentReservationList = new ArrayList<>();

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "room_reservation_discount")
    private BigDecimal roomReservationDiscount;

    @Column(name = "is_reservation_cancelled")
    private boolean isReservationCancelled;


//    public RoomReservation(Organisation organisation, ConferenceRoom roomId, List<AdditionalEquipmentReservation> additionalEquipmentReservationList,
//                           Date startDate, Time startTime, Date endDate, Time endTime, BigDecimal roomReservationDiscount, boolean isReservationCancelled) {
//        this.organisation = organisation;
//        this.roomId = roomId;
//        this.additionalEquipmentReservationList = additionalEquipmentReservationList;
//        this.startDate = startDate;
//        this.startTime = startTime;
//        this.endDate = endDate;
//        this.endTime = endTime;
//        this.roomReservationDiscount = roomReservationDiscount;
//        this.isReservationCancelled = isReservationCancelled;
//    }
}

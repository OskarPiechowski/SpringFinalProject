package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private long id;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;


    @ManyToOne
    @JoinColumn(name = "room_id")
    //tu do zmiany jest nazwa roomId, bo Ktoś zrobił kompozycję, ale te zmiany są rozległe, więc zostawiam na jakiś czas (TW)
    private ConferenceRoom conferenceRoom;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "room_reservation_discount")
    private BigDecimal roomReservationDiscount;

    @Column(name = "is_reservation_cancelled")
    private boolean isReservationCancelled;

}

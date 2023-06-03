package com.example.springfinalproject.service;

import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.repository.RoomReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {
    private final RoomReservationRepository reservationRepository;
    private final  AuthenticationService authenticationService;
    private final ConferenceRoomService conferenceRoomService;


    public List<RoomReservation> findAll() {
        return reservationRepository.findAll();
    }

    public RoomReservation getById(long id) {
        RoomReservation roomReservation = reservationRepository.findById(id);
        return roomReservation;
    }

    public RoomReservation save(RoomReservation reservation) {
        return reservationRepository.save(reservation);
    }

    public boolean existsById(int id) {
        return reservationRepository.existsById(id);
    }

    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }

    public void createReservation(RoomReservation reservation) {
    }

    public void setReservation(long roomId, RoomReservation reservation) {
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        ConferenceRoom conferenceRoom = conferenceRoomService.getConferenceRoomByIdasdsaidasd(roomId);
        reservation.setConferenceRoom(conferenceRoom);
        reservation.setOrganisation(organisation);
        save(reservation);
    }
}

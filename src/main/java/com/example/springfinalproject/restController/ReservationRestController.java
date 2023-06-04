package com.example.springfinalproject.restController;

import com.example.springfinalproject.controller.AuthenticationController;
import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.mapper.ConferenceRoomMapper;
import com.example.springfinalproject.service.AuthenticationService;
import com.example.springfinalproject.service.ConferenceRoomService;
import com.example.springfinalproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getReservationsApi() {
        return reservationService.findAll();
    }
}


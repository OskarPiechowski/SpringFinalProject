package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.service.ConferenceRoomService;
import com.example.springfinalproject.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class ReservationController {

    @Autowired
    @Qualifier("reservationService")
    private ReservationService reservationService;
    private ConferenceRoomService conferenceRoomService;

    @GetMapping("/reservations")
    public String getReservations(Model model) {
        List<RoomReservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations-list";
    }

    @PostMapping("/reservations")
    public String createReservation(@ModelAttribute("reservation") RoomReservation reservation) {
        reservationService.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/new")
    public String getReservationForm(Model model) {
        List<ConferenceRoomDto> roomDtos = conferenceRoomService.getAllRooms();
        model.addAttribute("roomDtos", roomDtos);
        model.addAttribute("reservation", new RoomReservation());
        return "reservation-form";
    }

    @GetMapping("/api/reservations")
    @ResponseBody
    public List<RoomReservation> getReservationsApi() {
        return reservationService.findAll();
    }
}
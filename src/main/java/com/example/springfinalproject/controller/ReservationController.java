package com.example.springfinalproject.controller;

import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    @Qualifier("reservationService")
    private ReservationService reservationService;

    @GetMapping
    public String getReservations(Model model) {
        List<RoomReservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations-list";
    }
}

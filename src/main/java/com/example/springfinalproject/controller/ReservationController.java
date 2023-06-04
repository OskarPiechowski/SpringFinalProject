package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.dto.RoomReservationDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.mapper.ConferenceRoomMapper;
import com.example.springfinalproject.service.AuthenticationService;
import com.example.springfinalproject.service.ConferenceRoomService;
import com.example.springfinalproject.service.ReservationService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping
public class ReservationController {

    @Autowired
    @Qualifier("reservationService")
    private ReservationService reservationService;
    private ConferenceRoomService conferenceRoomService;
    private ConferenceRoomMapper conferenceRoomMapper;

    private AuthenticationController authenticationController;

    private AuthenticationService authenticationService;

    @GetMapping("/reservations")
    public String getReservations(Model model) {
        List<RoomReservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations-list";
    }

//    @PostMapping("/reservations")
//    public String createReservation(@ModelAttribute("reservation") RoomReservation reservation,
//                                    @RequestParam("roomId") long roomId) {
//        reservationService.setReservation(roomId, reservation);
//        return "redirect:/api/reservations";
//    }

    @PostMapping("/reservations")
    public String createReservation(@ModelAttribute("reservation") RoomReservationDto roomReservationDto,
                                    @RequestParam("roomId") long roomId) {
        reservationService.setReservation(roomId, roomReservationDto);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/new")
    public String getReservationForm(@RequestParam("roomId") Long roomId, Model model) {
        List<ConferenceRoomDto> roomDtos = conferenceRoomService.getAllRooms();
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        model.addAttribute("roomDtos", roomDtos);
        model.addAttribute("reservation", new RoomReservation());
        model.addAttribute("roomId", roomId);
        model.addAttribute("organisationname", organisation);
        System.out.println("!!!!!!!!!!!!!!" + roomId + "!!!!!!!!!!!!!!");
        int x = roomId.intValue() - 1;
        System.out.println(roomDtos.get(x).getName());
        return "reservation-form";
    }

    @GetMapping("/api")
    public String redirectToApi() {
        return "redirect:/api/reservations";
    }
}
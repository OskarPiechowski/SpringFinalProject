package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.mapper.ConferenceRoomMapper;
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
    private ConferenceRoomMapper conferenceRoomMapper;

    @GetMapping("/reservations")
    public String getReservations(Model model) {
        List<RoomReservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations-list";
    }

//    było przed wprowadzeniem przekazywania parametru
    @PostMapping("/reservations")
    public String createReservation(@ModelAttribute("reservation") RoomReservation reservation) {
        Long roomId = 1L;
        ConferenceRoomDto conferenceRoom = conferenceRoomService.getConferenceRoomById(roomId);
        reservationService.save(reservation);
        return "redirect:/reservations";
    }


//    To niby powinno działać, ale leci 400
//    @PostMapping("/reservations")
//    public String createReservation(@ModelAttribute("reservation") RoomReservation reservation,
//                                    @RequestParam("roomId") Long roomId) {
//        ConferenceRoomDto conferenceRoomDto = conferenceRoomService.getConferenceRoomById(roomId);
//        ConferenceRoom conferenceRoom = conferenceRoomMapper.mapToEntity(conferenceRoomDto);
//        reservation.setRoomId(conferenceRoom);
//        reservationService.save(reservation);
//        return "redirect:/reservations";
//    }



    @GetMapping("/reservations/new")
    public String getReservationForm(@RequestParam("roomId") Long roomId, Model model) {
        List<ConferenceRoomDto> roomDtos = conferenceRoomService.getAllRooms();
        model.addAttribute("roomDtos", roomDtos);
        model.addAttribute("reservation", new RoomReservation());
        model.addAttribute("roomId", roomId);
        System.out.println("!!!!!!!!!!!!!!"+roomId+"!!!!!!!!!!!!!!");
        int x = roomId.intValue() - 1;
        System.out.println(roomDtos.get(x).getName());
        return "reservation-form";
    }

        @GetMapping("/api/reservations")
        @ResponseBody
        public List<RoomReservation> getReservationsApi () {
            return reservationService.findAll();
        }
    }
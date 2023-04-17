package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.service.ConferenceRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConferenceRoomController {

    private ConferenceRoomService conferenceRoomService = new ConferenceRoomService();


@GetMapping("/api/conferenceRoom")
    public ConferenceRoomDto getConferenceRoom(){
return new ConferenceRoomDto();
    }
    @GetMapping("/api/conferenceRooms")
    public List<ConferenceRoomDto> getAllConferenceRooms(){
return conferenceRoomService.allRooms();
    }

    //@GetMapping("/api/rooms/{number}")
//public RoomDto getRoomByNumber(@PathVariable int number){
//    return roomService.getRoomNumber(number);
//}

}

package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.service.ConferenceRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConferenceRoomController {

    private ConferenceRoomService conferenceRoomService;


    @GetMapping("/api/conferenceRoom")
    public ConferenceRoomDto getConferenceRoom(){
return new ConferenceRoomDto();
    }
    @GetMapping("/api/conferenceRooms")
    public List<ConferenceRoomDto> getAllConferenceRooms(){
return conferenceRoomService.allRooms();
    }

    @PostMapping("/api/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        conferenceRoomService.addRoom(conferenceRoomDto);
    }
    //@GetMapping("/api/rooms/{number}")
//public RoomDto getRoomByNumber(@PathVariable int number){
//    return roomService.getRoomNumber(number);
//}

}

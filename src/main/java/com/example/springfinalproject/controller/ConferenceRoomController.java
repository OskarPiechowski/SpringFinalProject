package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.service.ConferenceRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ConferenceRoomController {

    private ConferenceRoomService conferenceRoomService;

    @GetMapping("/list")
    public ResponseEntity<List<ConferenceRoomDto>> getAllConferenceRoom(){
        return ResponseEntity.ok().body(conferenceRoomService.getConferenceRoomList());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        conferenceRoomService.addRoom(conferenceRoomDto);
    }
    //@GetMapping("/api/rooms/{number}")
//public RoomDto getRoomByNumber(@PathVariable int number){
//    return roomService.getRoomNumber(number);
//}

}

package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;

    @GetMapping("/list")
    public ResponseEntity<List<RoomDto>> getAllConferenceRoom(){
        return ResponseEntity.ok().body(roomService.getConferenceRoomList());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createRoom(@RequestBody RoomDto roomDto) {
        roomService.addRoom(roomDto);
    }
    //@GetMapping("/api/rooms/{number}")
//public RoomDto getRoomByNumber(@PathVariable int number){
//    return roomService.getRoomNumber(number);
//}

}
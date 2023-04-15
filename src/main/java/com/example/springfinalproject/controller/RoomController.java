package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

@GetMapping("/api/room")

    public RoomDto getRoom(){
return new RoomDto();
    }
    @GetMapping("/api/rooms")
    public List<RoomDto> getAllRooms(){
return roomService.allRooms();
    }

    //@GetMapping("/api/rooms/{number}")
//public RoomDto getRoomByNumber(@PathVariable int number){
//    return roomService.getRoomNumber(number);
//}

}

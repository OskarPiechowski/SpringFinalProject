package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.RoomDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
@GetMapping("/api/room")
    public RoomDto getRoom(){
return new RoomDto();
    }
    @GetMapping("/api/rooms")
    public List<RoomDto> getAllRooms(){
return roomService.AllRooms();
    }
@GetMapping("/api/rooms/{number}")
public RoomDto getRoomByNumber(@PathVariable int number){
    return roomService.getRoomNumber(number);
}

}

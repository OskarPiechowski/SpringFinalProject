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
    public ResponseEntity<List<ConferenceRoomDto>> findAllConferenceRooms(){
        return ResponseEntity.ok().body(conferenceRoomService.getConferenceRooms());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createRoom(@RequestBody ConferenceRoomDto conferenceRoomDto) {
        conferenceRoomService.addConferenceRoom(conferenceRoomDto);
    }

    @GetMapping("/{id}")
    public ConferenceRoomDto findConferenceRoomById(@PathVariable Long id){
        ConferenceRoomDto conferenceRoomDto = conferenceRoomService.getConferenceRoomById(id);
        return conferenceRoomDto;
    }
    @DeleteMapping("/del/{id}")
    public void deleteConferenceRoom(@PathVariable Long id){
        conferenceRoomService.remove(id);
    }


}

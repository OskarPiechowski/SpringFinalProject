package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ConferenceRoomService {

    public ConferenceRoomService() {
    }

    public List<ConferenceRoomDto> allRooms() {
        return List.of(
                new ConferenceRoomDto(2L, "Room 2", "2", true, 100, 50, 2),
                new ConferenceRoomDto(3L, "Room 3", "3", true, 200, 150, 3),
                new ConferenceRoomDto(4L, "Room 4",  "4", true, 300, 250, 4)
        );
    }

}

package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.RoomDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomService {

    public List<RoomDto> allRooms() {
        return List.of(
                new RoomDto(2L, "Room 2", "2", true, 100, 50, 2),
                new RoomDto(3L, "Room 3", "3", true, 200, 150, 3),
                new RoomDto(4L, "Room 4",  "4", true, 300, 250, 4)
        );
    }

}

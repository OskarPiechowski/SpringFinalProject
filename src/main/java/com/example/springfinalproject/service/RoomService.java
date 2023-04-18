package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.entity.Room;
import com.example.springfinalproject.mapper.RoomMapper;
import com.example.springfinalproject.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RoomService {

    private RoomRepository conferenceRoomRepository;
    private RoomMapper conferenceRoomMapper;

    public void addRoom(RoomDto conferenceRoomDto){
        Room conferenceRoom = conferenceRoomMapper.mapToEntity(conferenceRoomDto);
        conferenceRoomRepository.save(conferenceRoom);
    }

    public List<RoomDto> getConferenceRoomList(){
        List<RoomDto> conferenceRoomDtos = new ArrayList<>();
        List<Room> conferenceRooms = conferenceRoomRepository.findAll();
        for (Room conferenceRoom : conferenceRooms){
            conferenceRoomDtos.add(conferenceRoomMapper.mapToDto(conferenceRoom));
        }
        return conferenceRoomDtos;
    }
//    public List<RoomDto> allRooms() {
//        return List.of(
//                new RoomDto(2L, "Room 2", "2", true, 100, 50, 2),
//                new RoomDto(3L, "Room 3", "3", true, 200, 150, 3),
//                new RoomDto(4L, "Room 4",  "4", true, 300, 250, 4)
//        );
//    }

}

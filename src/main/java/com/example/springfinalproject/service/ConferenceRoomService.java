package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.mapper.ConferenceRoomMapper;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ConferenceRoomService {

    private ConferenceRoomRepository conferenceRoomRepository;
    private ConferenceRoomMapper conferenceRoomMapper;

    public void addRoom(ConferenceRoomDto conferenceRoomDto){
        ConferenceRoom conferenceRoom = conferenceRoomMapper.mapToEntity(conferenceRoomDto);
        conferenceRoomRepository.save(conferenceRoom);
    }

    public List<ConferenceRoomDto> getConferenceRoomList(){
        List<ConferenceRoomDto> conferenceRoomDtos = new ArrayList<>();
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();
        for (ConferenceRoom conferenceRoom : conferenceRooms){
            conferenceRoomDtos.add(conferenceRoomMapper.mapToDto(conferenceRoom));
        }
        return conferenceRoomDtos;
    }

    public List<ConferenceRoomDto> allRooms() {
        return List.of(
                new ConferenceRoomDto(2L, "Room 2", "2", true, 100, 50, 2),
                new ConferenceRoomDto(3L, "Room 3", "3", true, 200, 150, 3),
                new ConferenceRoomDto(4L, "Room 4",  "4", true, 300, 250, 4)
        );
    }

}

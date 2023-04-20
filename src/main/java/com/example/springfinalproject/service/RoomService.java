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

    private RoomRepository roomRepository;
    private RoomMapper roomMapper;

    public void addRoom(RoomDto roomDto){
        Room room = roomMapper.mapToEntity(roomDto);
        roomRepository.save(room);
    }

    public List<RoomDto> getRoomList(){
        List<RoomDto> roomDtos = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms){
            roomDtos.add(roomMapper.mapToDto(room));
        }
        return roomDtos;
    }

    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(()->new NullPointerException("Room does not exist"));
        return roomMapper.mapToDto(room);
    }

}

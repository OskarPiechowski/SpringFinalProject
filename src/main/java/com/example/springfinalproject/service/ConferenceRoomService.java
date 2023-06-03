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

    public void addConferenceRoom(ConferenceRoomDto conferenceRoomDto){
        ConferenceRoom conferenceRoom = conferenceRoomMapper.mapToEntity(conferenceRoomDto);
        conferenceRoomRepository.save(conferenceRoom);
    }

    public List<ConferenceRoomDto> getConferenceRooms(){
        List<ConferenceRoomDto> conferenceRoomDtos;
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();
        conferenceRoomDtos = conferenceRoomMapper.mapToDtos(conferenceRooms);
//        for (ConferenceRoom conferenceRoom : conferenceRooms){
//            conferenceRoomDtos.add(conferenceRoomMapper.mapToDto(conferenceRoom));
//        }
        return conferenceRoomDtos;
    }

    public ConferenceRoomDto getConferenceRoomById(Long id) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(id).orElseThrow(()->new NullPointerException("Room does not exist"));

        return conferenceRoomMapper.mapToDto(conferenceRoom);
    }

    public void remove(Long id) {
        conferenceRoomRepository.deleteById(id);
    }
    public List<ConferenceRoomDto> searchConferenceRoomBySits(int sits) {
        List<ConferenceRoomDto> conferenceRoomDtos = new ArrayList<>();
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findBySits(sits);
        for (ConferenceRoom conferenceRoom : conferenceRooms){
            conferenceRoomDtos.add(conferenceRoomMapper.mapToDto(conferenceRoom));
        }
        return conferenceRoomDtos;
    }

    public List<ConferenceRoomDto> getAllRooms() {
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();
        List<ConferenceRoomDto> conferenceRoomDtos = new ArrayList<>();
        for (ConferenceRoom conferenceRoom : conferenceRooms) {
            conferenceRoomDtos.add(conferenceRoomMapper.mapToDto(conferenceRoom));
        }
        return conferenceRoomDtos;
    }

    public List<ConferenceRoomDto> getAllRoomDtos() {
        return getAllRooms();
    }

    public ConferenceRoom getConferenceRoomByIdasdsaidasd(long id) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(id).orElseThrow(()->new NullPointerException("Room does not exist"));
        return conferenceRoom;
    }
}

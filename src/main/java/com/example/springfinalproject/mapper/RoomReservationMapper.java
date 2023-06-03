package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.dto.RoomReservationDto;
import com.example.springfinalproject.entity.AdditionalEquipment;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.service.ConferenceRoomService;
import com.example.springfinalproject.service.ReservationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomReservationMapper {



    public List<RoomReservationDto> mapToDtos(List<RoomReservation> roomReservations){
        return roomReservations.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<RoomReservation> mapToEntities(List<RoomReservationDto> roomReservationDtos){
        return roomReservationDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public RoomReservationDto mapToDto(RoomReservation roomReservation){
        RoomReservationDto roomReservationDto = new RoomReservationDto();
        roomReservationDto.setId(roomReservation.getId());
        roomReservationDto.setStartDate(roomReservation.getStartDate());
        roomReservationDto.setConferenceRoomId(roomReservation.getConferenceRoom().getId());
        return roomReservationDto;
    }
    public RoomReservation mapToEntity(RoomReservationDto roomReservationDto){
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setId(roomReservationDto.getId());
        roomReservation.setStartDate(roomReservationDto.getStartDate());
        roomReservation.setStartTime(roomReservationDto.getStartTime());
        roomReservation.setEndDate(roomReservationDto.getEndDate());
        roomReservation.setStartTime(roomReservationDto.getEndTime());
        return roomReservation;
    }
}

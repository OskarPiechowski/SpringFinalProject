package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConferenceRoomMapper {

    public List<ConferenceRoomDto> mapToDtos(List<ConferenceRoom> conferenceRooms){
        return conferenceRooms.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<ConferenceRoom> mapToEntities(List<ConferenceRoomDto> conferenceRoomDtos){
        return conferenceRoomDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public ConferenceRoomDto mapToDto(ConferenceRoom conferenceRoom){
        return ConferenceRoomDto.builder()
                .id(conferenceRoom.getId())
                .name(conferenceRoom.getName())
                .floor(conferenceRoom.getFloor())
                .availability(conferenceRoom.isAvailability())
                .sittingPlace(conferenceRoom.getSittingPlace())
                .standingPlace(conferenceRoom.getStandingPlace())
                .roomNumber(conferenceRoom.getRoomNumber())
                .build();
    }
    public ConferenceRoom mapToEntity(ConferenceRoomDto conferenceRoomDto){
        return new ConferenceRoom(
                conferenceRoomDto.getId(),
                conferenceRoomDto.getName(),
                conferenceRoomDto.getFloor(),
                conferenceRoomDto.isAvailability(),
                conferenceRoomDto.getSittingPlace(),
                conferenceRoomDto.getStandingPlace(),
                conferenceRoomDto.getRoomNumber());
    }
}

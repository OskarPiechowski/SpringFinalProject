package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.ConferenceRoom;
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
                .sits(conferenceRoom.getSits())
                .whiteboard(conferenceRoom.getWhiteboard())
                .standingPlace(conferenceRoom.getStandingPlace())
                .bed(conferenceRoom.getBed())
                .projector(conferenceRoom.getProjector())
                .view(conferenceRoom.getView())
                .isRoomForRenting(conferenceRoom.isRoomForRenting())
                .pricePerHour(conferenceRoom.getPricePerHour())
                .pricePerDay(conferenceRoom.getPricePerDay())
                .roomReservationList(conferenceRoom.getRoomReservationList())
                .build();
    }
    public ConferenceRoom mapToEntity(ConferenceRoomDto conferenceRoomDto){
        return new ConferenceRoom(
                conferenceRoomDto.getId(),
                conferenceRoomDto.getName(),
                conferenceRoomDto.getFloor(),
                conferenceRoomDto.isAvailability(),
                conferenceRoomDto.getSits(),
                conferenceRoomDto.getWhiteboard(),
                conferenceRoomDto.getStandingPlace(),
                conferenceRoomDto.getBed(),
                conferenceRoomDto.getProjector(),
                conferenceRoomDto.getView(),
                conferenceRoomDto.isRoomForRenting(),
                conferenceRoomDto.getPricePerHour(),
                conferenceRoomDto.getPricePerDay(),
                conferenceRoomDto.getRoomReservationList()
        );
    }
}

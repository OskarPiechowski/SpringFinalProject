package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapper {

    public List<RoomDto> mapToDtos(List<Room> conferenceRooms){
        return conferenceRooms.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<Room> mapToEntities(List<RoomDto> conferenceRoomDtos){
        return conferenceRoomDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public RoomDto mapToDto(Room room){
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .floor(room.getFloor())
                .availability(room.isAvailability())
                .sits(room.getSits())
                .table(room.getTable())
                .standingPlace(room.getStandingPlace())
                .bed(room.getBed())
                .projector(room.getProjector())
                .schema(room.getSchema())
                .isRoomForRenting(room.isRoomForRenting())
                .pricePerHour(room.getPricePerHour())
                .pricePerDay(room.getPricePerDay())
                .build();
    }
    public Room mapToEntity(RoomDto roomDto){
        return new Room(
                roomDto.getId(),
                roomDto.getName(),
                roomDto.getFloor(),
                roomDto.isAvailability(),
                roomDto.getSits(),
                roomDto.getTable(),
                roomDto.getStandingPlace(),
                roomDto.getBed(),
                roomDto.getProjector(),
                roomDto.getSchema(),
                roomDto.isRoomForRenting(),
                roomDto.getPricePerHour(),
                roomDto.getPricePerDay()
        );
    }
}
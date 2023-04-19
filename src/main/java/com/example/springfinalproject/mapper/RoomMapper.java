package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapper {

    public List<RoomDto> mapToDtos(List<Room> rooms){
        return rooms.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<Room> mapToEntities(List<RoomDto> roomDtos){
        return roomDtos.stream()
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
                .whiteboard(room.getWhiteboard())
                .standingPlace(room.getStandingPlace())
                .bed(room.getBed())
                .projector(room.getProjector())
                .view(room.getView())
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
                roomDto.getWhiteboard(),
                roomDto.getStandingPlace(),
                roomDto.getBed(),
                roomDto.getProjector(),
                roomDto.getView(),
                roomDto.isRoomForRenting(),
                roomDto.getPricePerHour(),
                roomDto.getPricePerDay()
        );
    }
}

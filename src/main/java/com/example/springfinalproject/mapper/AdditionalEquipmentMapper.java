package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.AdditionalEquipment;
import com.example.springfinalproject.entity.ConferenceRoom;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdditionalEquipmentMapper {
    public List<AdditionalEquipmentDto> mapToDtos(List<AdditionalEquipment> additionalEquipments){
        return additionalEquipments.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<AdditionalEquipment> mapToEntities(List<AdditionalEquipmentDto> additionalEquipmentDtos){
        return additionalEquipmentDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public AdditionalEquipmentDto mapToDto(AdditionalEquipment additionalEquipment){
        return AdditionalEquipmentDto.builder()
                .id(additionalEquipment.getId())
                .projectorName(additionalEquipment.getProjectorName())
                .amount(additionalEquipment.getAmount())
                .phone(additionalEquipment.isPhone())
                .internalNumber(additionalEquipment.getInternalNumber())
                .externalNumber(additionalEquipment.getExternalNumber())
                .pricePerDay(additionalEquipment.getPricePerDay())
                .build();
    }
    public AdditionalEquipment mapToEntity(AdditionalEquipmentDto additionalEquipmentDto){
        return new AdditionalEquipment(
                additionalEquipmentDto.getId(),
                additionalEquipmentDto.getProjectorName(),
                additionalEquipmentDto.getAmount(),
                additionalEquipmentDto.isPhone(),
                additionalEquipmentDto.getInternalNumber(),
                additionalEquipmentDto.getExternalNumber(),
                additionalEquipmentDto.getInterfaceUSB(),
                additionalEquipmentDto.getPricePerHour(),
                additionalEquipmentDto.getPricePerDay());
    }
}

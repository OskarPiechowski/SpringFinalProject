package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.AdditionalEquipment;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.mapper.AdditionalEquipmentMapper;
import com.example.springfinalproject.repository.AdditionalEquipmentRepository;

public class AdditionalEquipmentService {

    private AdditionalEquipmentRepository additionalEquipmentRepository;
    private AdditionalEquipmentMapper additionalEquipmentMapper;

    public void addAdditionalEquipmentToConferenceRoom(){
        ConferenceRoomDto conferenceRoomDto = new ConferenceRoomDto();
        AdditionalEquipment additionalEquipment = new AdditionalEquipment();
        AdditionalEquipmentDto additionalEquipmentDto = additionalEquipmentMapper.mapToDto(additionalEquipmentRepository.findById(1L).orElseThrow(()-> new NullPointerException()));
        conferenceRoomDto.setAdditionalEquipment(additionalEquipment);
    }
}

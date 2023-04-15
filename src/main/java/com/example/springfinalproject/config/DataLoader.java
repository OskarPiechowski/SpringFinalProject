package com.example.springfinalproject.config;

import com.example.springfinalproject.entity.OrganisationEntity;
import com.example.springfinalproject.entity.RoomEntity;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component

public class DataLoader implements ApplicationListener <ContextRefreshedEvent>{

    private RoomRepository roomRepository;
    private OrganisationRepository organizationRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setName("Room 1");
        roomRepository.save(roomEntity);

        OrganisationEntity organisationEntity = new OrganisationEntity();
        organisationEntity.setName("Comarch");
        organizationRepository.save(organisationEntity);
    }
}

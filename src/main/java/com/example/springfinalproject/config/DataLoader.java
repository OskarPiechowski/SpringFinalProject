package com.example.springfinalproject.config;

import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener <ContextRefreshedEvent>{

    private ConferenceRoomRepository roomRepository;
    private OrganisationRepository organizationRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ConferenceRoom roomEntity = new ConferenceRoom();
        roomEntity.setName("Room 1");
        roomRepository.save(roomEntity);

        Organisation organisation = new Organisation();
        organisation.setName("Comarch");
        organizationRepository.save(organisation);

        Organisation organisation1 = new Organisation();
        organisation1.setId(1L);
        organisation1.setName("Żabka");
        organisation1.setAddress("Zbaraska 5");
        organisation1.setNip(7732457725L);
        organisation1.setCity("Łódź");
        organisation1.setPostcode(93-208);
        organizationRepository.save(organisation1);
    }
}

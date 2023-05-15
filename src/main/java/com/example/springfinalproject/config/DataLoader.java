package com.example.springfinalproject.config;

import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener <ContextRefreshedEvent>{

    private ConferenceRoomRepository roomRepository;
    private OrganisationRepository organizationRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ConferenceRoom roomEntity = new ConferenceRoom();
        roomEntity.setName("Room 1");
        roomEntity.setFloor(1);
        roomEntity.setAvailability(true);
        roomEntity.setSits(400);
        roomEntity.setStandingSits(200);
        roomEntity.setLayingSits(10);
        roomEntity.setHangingSits(100);
        roomEntity.setPricePerHour(new BigDecimal(200));
        roomEntity.setPricePerDay(new BigDecimal(800));
        roomRepository.save(roomEntity);

        Organisation organisation = new Organisation();
        organisation.setName("Comarch");
        organisation.setCity("Kraków");
        organizationRepository.save(organisation);

        Organisation organisation1 = new Organisation();
        organisation1.setId(1L);
        organisation1.setName("Żabka");
        organisation1.setAddress("Zbaraska 5");
        organisation1.setNip("167732457725");
        organisation1.setCity("Łódź");
        organisation1.setPostcode("93208");
        organizationRepository.save(organisation1);

    }
}

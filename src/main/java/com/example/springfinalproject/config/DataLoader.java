package com.example.springfinalproject.config;

import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.Room;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener <ContextRefreshedEvent>{

    private RoomRepository roomRepository;
    private OrganisationRepository organizationRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Room roomEntity = new Room();
        roomEntity.setName("Room 1");
        roomEntity.setFloor("1");
        roomEntity.setAvailability(true);
        roomEntity.setSits(400);
        roomEntity.setTable(2);
        roomEntity.setStandingPlace(100);
        roomEntity.setBed(10);
        roomEntity.setProjector(2);
        roomEntity.setSchema(1);
        roomEntity.setRoomForRenting(true);
        roomEntity.setPricePerHour(new BigDecimal(200));
        roomEntity.setPricePerDay(new BigDecimal(800));
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

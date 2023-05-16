package com.example.springfinalproject.config;

import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private ConferenceRoomRepository roomRepository;
    private OrganisationRepository organizationRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
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

        } catch (Exception exception) {
            logger.error("Wystąpił błąd podczas inicjalizacji danych, np. naruszenie ograniczenia unikalności lub inny," +
                    " ale aplikacja rusza dalej");
//Poniższe linie zostawiam do ewentualnego przyszłego logowania do bazy lub pliku, a może Ktoś z Was wolałby,
// aby pojawiał się czerwony napis w konsoli, kiedy wystąpi błąd? Teraz jest on prawie niewidoczny. Prawie
//            logger.error("Wystąpił błąd podczas inicjalizacji danych - naruszenie ograniczenia unikalności", exception);
//            System.err.println("Wystąpił błąd podczas inicjalizacji danych - naruszenie ograniczenia unikalności");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}

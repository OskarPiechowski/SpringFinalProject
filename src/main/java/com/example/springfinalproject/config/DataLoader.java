package com.example.springfinalproject.config;

import com.example.springfinalproject.common.InterfaceUSB;
import com.example.springfinalproject.controller.AdditionalEquipmentController;
import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.entity.AdditionalEquipment;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.repository.AdditionalEquipmentRepository;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import jakarta.transaction.Transactional;
import com.example.springfinalproject.repository.RoomReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private ConferenceRoomRepository roomRepository;
    private OrganisationRepository organizationRepository;
    private RoomReservationRepository roomReservationRepository;
    private AdditionalEquipmentRepository additionalEquipmentRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
            AdditionalEquipment additionalEquipment2 = new AdditionalEquipment();
            additionalEquipment2.setProjectorName("Projector XYZ");
            additionalEquipment2.setAmount(5);
            additionalEquipment2.setPhone(true);
            additionalEquipment2.setInternalNumber(10);
            additionalEquipment2.setExternalNumber("+48 1234567890");
            additionalEquipment2.setInterfaceUSB(InterfaceUSB.TRUE);
            additionalEquipment2.setPricePerHour(BigDecimal.valueOf(50));
            additionalEquipment2.setPricePerDay(BigDecimal.valueOf(200));
            additionalEquipmentRepository.save(additionalEquipment2);


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
            roomEntity.setAdditionalEquipment(additionalEquipment2);
            roomRepository.save(roomEntity);

            ConferenceRoom roomEntity2 = new ConferenceRoom();
            roomEntity2.setName("Room 2");
            roomEntity2.setFloor(2);
            roomEntity2.setAvailability(true    );
            roomEntity2.setSits(500);
            roomEntity2.setStandingSits(300);
            roomEntity2.setLayingSits(20);
            roomEntity2.setHangingSits(200);
            roomEntity2.setPricePerHour(new BigDecimal(100));
            roomEntity2.setPricePerDay(new BigDecimal(700));
            roomEntity2.setAdditionalEquipment(additionalEquipment2);
            roomRepository.save(roomEntity2);


            Organisation organisation = new Organisation();
            organisation.setName("Comarch");
            organisation.setCity("Kraków");
            organisation.setPostcode("31864");
            organisation.setNip("6770065406");
            organisation.setAddress("al. Jana Pawła II 39a");
            organisation.setEmail("comarch@comarch.pl");
            organisation.setLoginPassword(passwordEncoder.encode("comarch"));
            organizationRepository.save(organisation);


            Organisation organisation1 = new Organisation();
            organisation1.setId(2L);
            organisation1.setName("Żabka");
            organisation1.setAddress("Zbaraska 5");
            organisation1.setNip("167732457725");
            organisation1.setCity("Łódź");
            organisation1.setPostcode("93208");
            organizationRepository.save(organisation1);

            Organisation organisation2 = new Organisation();
            organisation2.setName("a");
            organisation2.setCity("a");
            organisation2.setPostcode("a");
            organisation2.setNip("1");
            organisation2.setAddress("a");
            organisation2.setEmail("a@a.pl");
            organisation2.setLoginPassword(passwordEncoder.encode("a"));
            organizationRepository.save(organisation2);


            RoomReservation roomReservation = RoomReservation.builder()
                    .organisation(organisation1) // obiekt klasy Organisation
                    .conferenceRoom(roomEntity) // obiekt klasy ConferenceRoom
                    .startDate(LocalDate.of(2023, 5, 1))
                    .startTime(LocalTime.of(10, 0))
                    .endDate(LocalDate.of(2023, 5, 1))
                    .endTime(LocalTime.of(12, 0))
                    .roomReservationDiscount(BigDecimal.valueOf(10))
                    .isReservationCancelled(false)
                    .build();
            roomReservationRepository.save(roomReservation);

            RoomReservation roomReservation1 = RoomReservation.builder()
                    .organisation(organisation) // obiekt klasy Organisation
                    .conferenceRoom(roomEntity) // obiekt klasy ConferenceRoom
                    .startDate(LocalDate.of(2023, 5, 11))
                    .startTime(LocalTime.of(10, 0))
                    .endDate(LocalDate.of(2023, 5, 12))
                    .endTime(LocalTime.of(12, 0))
                    .roomReservationDiscount(BigDecimal.valueOf(20))
                    .isReservationCancelled(true)
                    .build();
            roomReservationRepository.save(roomReservation1);

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

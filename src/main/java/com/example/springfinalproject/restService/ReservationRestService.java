package com.example.springfinalproject.restService;

import com.example.springfinalproject.exceptions.InvoiceAlreadyExistsException;
import com.example.springfinalproject.repository.RoomReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationRestService {

    private final RoomReservationRepository roomReservationRepository;


    public ReservationRestService(RoomReservationRepository roomReservationRepository) {
        this.roomReservationRepository = roomReservationRepository;
    }

    public void checkInvoiceExistenceByReservationId(Long reservationId) {
        if (roomReservationRepository.existsById(reservationId)) {
            throw new InvoiceAlreadyExistsException("Invoice already exists for reservation ID: " + reservationId);
        }
    }

}


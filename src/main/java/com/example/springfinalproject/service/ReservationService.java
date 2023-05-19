package com.example.springfinalproject.service;

import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.repository.RoomReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {
    private final RoomReservationRepository reservationRepository;

    public List<RoomReservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Object> findById(int id) {
        return reservationRepository.findById(id);
    }

    public RoomReservation save(RoomReservation reservation) {
        return reservationRepository.save(reservation);
    }

    public boolean existsById(int id) {
        return reservationRepository.existsById(id);
    }

    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }

    public void createReservation(RoomReservation reservation) {
    }
}

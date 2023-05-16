package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Role;
import com.example.springfinalproject.entity.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomReservationRepository extends JpaRepository<RoomReservation,Integer> {
    List<RoomReservation> findAll();

    Optional<Object> findById(int id);

    RoomReservation save(RoomReservation reservation);

    boolean existsById(int id);

    void deleteById(int id);
}

package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRoomRepository extends JpaRepository <Room, Long>{
}

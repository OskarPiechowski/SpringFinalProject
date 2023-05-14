package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConferenceRoomRepository extends JpaRepository <ConferenceRoom, Long>{

    @Query("from ConferenceRoom c where c.sits > :sits")
    List<ConferenceRoom> findBySits(@Param("sits") int sits);
}

package com.example.springfinalproject.repository;

import com.example.springfinalproject.dto.RoomDto;
import com.example.springfinalproject.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <RoomEntity, Long>{
}

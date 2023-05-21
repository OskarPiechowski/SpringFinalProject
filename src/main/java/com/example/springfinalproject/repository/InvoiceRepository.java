package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.entity.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}

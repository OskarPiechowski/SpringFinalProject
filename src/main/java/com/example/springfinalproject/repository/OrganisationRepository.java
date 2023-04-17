package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    Organisation findByNip(long nip);

    List<Organisation> findByCity(String city);
}
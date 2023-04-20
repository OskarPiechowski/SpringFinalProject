package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {

    List<Organisation> findByNip(String nip);

    List<Organisation> findByCity(String city);


}

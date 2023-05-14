package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {

    Boolean existsByEmail(String email);

    Boolean existsByName(String name);
    Optional<Organisation> findByEmail(String email);
    Optional<Organisation> findByName(String name);
    Optional<Organisation> findByNameOrEmail(String name,String email);

    List<Organisation> findByNip(long nip);

    List<Organisation> findByCity(String city);


}

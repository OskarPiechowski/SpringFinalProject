package com.example.springfinalproject.repository;

import com.example.springfinalproject.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<OrganisationEntity,Long> {
}

package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "inovices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private Integer id;
    @Column(name="invoice_number")
    private String number;
    @Column(name="invoice_organisation_name")
    private String name;
    @Column(name="invoice_organisation_nip")
    private Long nip;
    @Column(name="invoice_organisation_address")
    private String address;
    @Column(name="invoice_organisation_postcode")
    private String postcode;
    @Column(name="invoice_organisation_city")
    private String city;
    @Column(name="room_id")
    private Long room_id;
    @Column(name="value")
    private double value;
    @Column(name="invoice_Date")
    private LocalDateTime date;



}

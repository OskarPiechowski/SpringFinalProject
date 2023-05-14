package com.example.springfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private long nip;

    @Column(name="invoice_organisation_address")
    private String address;

    @Column(name="invoice_organisation_city")
    private String city;

    @Column(name="invoice_organisation_postcode")
    private int postcode;

    @Column(name="room_id")
    private Long room_id;


}

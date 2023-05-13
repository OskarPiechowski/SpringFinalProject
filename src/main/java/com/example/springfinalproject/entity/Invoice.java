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
    private Integer invoice_id;
    private String invoice_number;

    private String invoice_organisation_name;
    private long invoice_organisation_nip;
    private String invoice_organisation_address;

    private String invoice_organisation_city;

    private int invoice_organisation_postcode;

    private Long conference_room_id;


}

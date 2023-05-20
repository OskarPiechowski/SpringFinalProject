package com.example.springfinalproject.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    @Column(unique = true)
    private long id;
    private String number;
    private String name;
    @Column(unique = true)
    @Pattern(regexp = "^16\\d{10}$")
    private Long nip;

    private String address;

    private String postcode;

    private String city;

    private Long room_id;

    private Double value;

    private LocalDateTime date;

    public InvoiceDto(String name, Long nip) {
        this.name = name;
        this.nip = nip;
    }


    @Override
    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", room_id=" + room_id +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}

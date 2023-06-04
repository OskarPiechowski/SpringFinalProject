package com.example.springfinalproject.mapper;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InvoiceMapper {

    public List<InvoiceDto> mapToDtos(List<Invoice> invoices) {
        return invoices.stream()
                .map(this::mapToDto)
                .toList();
    }


    public List<Invoice> mapToEntities(List<InvoiceDto> invoiceDtos) {
        return invoiceDtos.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public InvoiceDto mapToDto(Invoice invoice) {
        return InvoiceDto.builder()
                .id(invoice.getId())
                .name(invoice.getName())
                .address(invoice.getAddress())
                .nip(invoice.getNip())
                .city(invoice.getCity())
                .date(invoice.getDate())
                .number(invoice.getNumber())
                .value(invoice.getValue())
                .room_id(invoice.getRoom_id())
                .postcode(invoice.getPostcode())
                .reservationId(invoice.getReservationId())
                .build();

    }

    public Invoice mapToEntity(InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getId()
                ,invoiceDto.getName()
                ,invoiceDto.getAddress()
                ,invoiceDto.getNip()
                ,invoiceDto.getCity()
                ,invoiceDto.getNumber()
                ,invoiceDto.getPostcode()
                ,invoiceDto.getRoom_id()
                ,invoiceDto.getValue()
                ,invoiceDto.getDate()
                ,invoiceDto.getReservationId());
    }
}

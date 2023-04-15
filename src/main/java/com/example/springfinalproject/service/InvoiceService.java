package com.example.springfinalproject.service;
import com.example.springfinalproject.dto.InvoiceDto;

import java.util.List;

public class InvoiceService {
    public List<InvoiceDto> AllInvoices() {
        return List.of(
                new InvoiceDto("ROU", 1, 2000),
                new InvoiceDto("LUNA", 11, 3000),
                new InvoiceDto("Karolina", 22, 2500)
        );
    }
}

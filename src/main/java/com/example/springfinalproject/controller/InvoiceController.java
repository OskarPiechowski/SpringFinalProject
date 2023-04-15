package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import org.springframework.web.bind.annotation.GetMapping;

public class InvoiceController {

    @GetMapping("/api/invoice")
    public InvoiceDto getInvoice(){
        return new InvoiceDto("P.H.KAROLINA", 1, 1000);
    }
}

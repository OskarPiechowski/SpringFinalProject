package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {
    private InvoiceService invoiceService;
    @GetMapping("/api/invoices")
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.AllInvoices();
    }

    @GetMapping("/api/invoice")
    public InvoiceDto getInvoice(){
        return new InvoiceDto("P.H.KAROLINA", 1, 1000);
    }
}

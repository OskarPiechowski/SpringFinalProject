package com.example.springfinalproject.restController;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.restService.InvoiceRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceRestController {

    private final InvoiceRestService invoiceRestService;

    public InvoiceRestController(InvoiceRestService invoiceRestService) {
        this.invoiceRestService = invoiceRestService;
    }

    @GetMapping
    public List<Invoice> getInvoiceApi(){
        return invoiceRestService.findAll();
    }

    @GetMapping("/a")
    public Invoice getInvoice(){
        Invoice invoice = new Invoice();
        return invoice;
    }

    @PostMapping("/{reservationId}")
    public ResponseEntity<InvoiceDto> createInvoice(@PathVariable("reservationId") Long reservationId) {
        InvoiceDto invoiceDto = invoiceRestService.createInvoice(reservationId);
        if (invoiceDto != null) {
            return ResponseEntity.ok(invoiceDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

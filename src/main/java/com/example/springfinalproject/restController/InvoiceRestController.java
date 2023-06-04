package com.example.springfinalproject.restController;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.exceptions.InvoiceAlreadyExistsException;
import com.example.springfinalproject.restService.InvoiceRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceRestController {

    private final InvoiceRestService invoiceRestService;

    public InvoiceRestController(InvoiceRestService invoiceRestService) {
        this.invoiceRestService = invoiceRestService;
    }

    @GetMapping
    public List<InvoiceDto> getInvoiceApi(){
        return invoiceRestService.getAllInvoices();
    }


    @PostMapping()
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        try{
           InvoiceDto newInvoiceDto = invoiceRestService.createInvoice(invoiceDto);
            return ResponseEntity.ok(newInvoiceDto);
       }catch (NoSuchElementException e) {
           return ResponseEntity.notFound().build();
       }catch (InvoiceAlreadyExistsException e) {
           return ResponseEntity.badRequest().header("error", e.getMessage()).build();
       }
    }
}

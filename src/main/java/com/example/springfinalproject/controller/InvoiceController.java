package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.service.InvoiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class InvoiceController {

    private InvoiceService invoiceService;

    @GetMapping("/")
    public String getMainPage(){
        return "main-page";
    }
    @GetMapping("/invoice/create")
    public String getInvoice(){
return "new-invoice";
    }
    @PostMapping("/invoice/create")
    public String addInvoice(InvoiceDto request){
        invoiceService.addInvoice(request);
        return "main-page";
    }
}

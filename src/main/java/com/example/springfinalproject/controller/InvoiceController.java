package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.service.InvoiceService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@NoArgsConstructor
@Controller
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    public String getMainPage(){
        return "main-page";
    }
    @GetMapping("/invoice")
    public ModelAndView getInvoice(){
return new ModelAndView("new-invoice");
    }
    @PostMapping("/invoice")
    public void addInvoice(InvoiceDto invoiceRequest){
        invoiceService.addInvoice(invoiceRequest);
    }
}

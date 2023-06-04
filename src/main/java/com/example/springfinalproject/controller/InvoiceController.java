package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.frontend.RestApiClient;
import com.example.springfinalproject.service.InvoiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
//Maciej mówi: usuń NoArgsController
//@NoArgsConstructor
@Controller
public class InvoiceController {
    private InvoiceService invoiceService;
    private RestApiClient restApiClient;

    /*   @GetMapping("/")
       public String getMainPage(){
           return "main-page";
       }*/
    @PostMapping("/invoice/new")
    public String addInvoice(InvoiceDto invoiceRequest) {
        invoiceService.addInvoice(invoiceRequest);
        return "redirect:/";
    }

    @GetMapping("/invoices")
    public String getAllInvoice(Model model) {
//        List<Invoice> invoice = invoiceService.findAllInvoices();
        List<InvoiceDto> invoicesDto = restApiClient.sendListProductHttpRequest();
        model.addAttribute("invoices", invoicesDto);
        return "invoices-list";
    }

    @GetMapping("/invoice/new")
    public ModelAndView getInvoice() {
        return new ModelAndView("invoice-form");
    }

    @GetMapping("/request-invoice")
    public String showInvoiceRequestForm() {
        return "request-invoice"; // Zwróć nazwę widoku HTML
    }
}
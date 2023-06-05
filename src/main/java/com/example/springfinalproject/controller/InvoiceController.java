package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.exceptions.InvoiceAlreadyExistsException;
import com.example.springfinalproject.frontend.RestApiClient;
import com.example.springfinalproject.repository.InvoiceRepository;
import com.example.springfinalproject.service.InvoiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
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

    private InvoiceRepository invoiceRepository;

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
    public String showInvoiceRequestForm(Model model) {
        return "request-invoice";
    }

    @PostMapping("/request-invoice")
    public String  createNewInvoice(@RequestParam long reservationId, Model model){
        try{
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setReservationId(reservationId);
            restApiClient.addInvoiceHttpRequest(invoiceDto);
            model.addAttribute("message", "Invoice added successfully");
        }catch (HttpClientErrorException.BadRequest e){
            model.addAttribute("message", "This invoice already exists. You can select another");
        }
        return "main-page";
    }
}
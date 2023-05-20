package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.service.InvoiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class InvoiceController {
@Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public String getMainPage(){

        return "main-page";
    }
    @GetMapping("/invoice")
    public ModelAndView getInvoice(){
return new ModelAndView("new-invoice");
    }
    @PostMapping("/invoice")
    public String addInvoice(InvoiceDto invoiceRequest){
        invoiceService.addInvoice(invoiceRequest);
        return "redirect:/";
    }
}

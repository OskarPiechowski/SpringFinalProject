package com.example.springfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class InvoiceController {

    @GetMapping("/")
    public String getMainPage(){
        return "main-page";
    }
    @GetMapping("/invoice/create")
    public String getInvoice(){
return "new-invoice";
    }
    @PostMapping("/invoice/create")
    public String addInvoice(String name, String address, String postcode, String city, Long nip, LocalDateTime date){
        System.out.println(name);
        System.out.println(address);
        System.out.println(postcode);
        System.out.println(city);
        System.out.println(nip);
        System.out.println(date);
        return "main-page";
    }
}

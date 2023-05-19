package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.service.AdditionalEquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class AdditionalEquipmentController {

    private AdditionalEquipmentService additionalEquipmentService;
    @GetMapping("/add-equipment")
    public String getPage() {
        return "add-additional-equipment.html";
    }

    @PostMapping("/add-equipment")
    public String createAdditionalEquipment(AdditionalEquipmentDto additionalEquipmentDto, Model model) {
        System.out.println(additionalEquipmentDto);
        additionalEquipmentService.addAdditionalEquipment(additionalEquipmentDto);
        model.addAttribute("message", "Dosałeś wyposażenie dodatkowe");
        return "add-additional-equipment.html";
    }
}

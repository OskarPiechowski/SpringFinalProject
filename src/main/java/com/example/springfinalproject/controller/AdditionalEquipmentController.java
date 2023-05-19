package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.service.AdditionalEquipmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdditionalEquipmentController {

    private AdditionalEquipmentService additionalEquipmentService;
    @GetMapping("/add-equipment")
    public String getPage() {
        return "add-additional-equipment.html";
    }

    @PostMapping("/add-equipment")
    public String createAdditionalEquipment(@Valid AdditionalEquipmentDto additionalEquipmentDto, Model model) {
        System.out.println(additionalEquipmentDto);
        additionalEquipmentService.addAdditionalEquipment(additionalEquipmentDto);
        model.addAttribute("message", "Dosałeś wyposażenie dodatkowe");
        return "add-additional-equipment.html";
    }
    @GetMapping("/additional-equipments")
    public String getAllAdditionalEquipment(Model model) {
        List<AdditionalEquipmentDto> additionalEquipmentDtos = additionalEquipmentService.findAllEquipment();
        model.addAttribute("equipments", additionalEquipmentDtos);
        return "additional-equipment-list";
    }
}

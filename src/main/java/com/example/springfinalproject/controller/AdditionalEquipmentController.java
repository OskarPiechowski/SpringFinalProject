package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.dto.ConferenceRoomDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.service.AdditionalEquipmentService;
import com.example.springfinalproject.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class AdditionalEquipmentController {

    private AdditionalEquipmentService additionalEquipmentService;
    private AuthenticationService authenticationService;
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
    @GetMapping("/additional-equipments")
    public String getAllAdditionalEquipment(Model model) {
        /* linijki kodu od 40 do 44 napisane tylko, by sprawdzić czy udało się pobrać zalogowanę organizację*/
        boolean logged = authenticationService.selectLoggedOrganisation().isPresent();
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        System.out.println(logged);
        System.out.println(organisation);
        List<AdditionalEquipmentDto> additionalEquipmentDtos = additionalEquipmentService.findAllEquipment();
        model.addAttribute("equipments", additionalEquipmentDtos);
        return "additional-equipment-list";
    }

    @PostMapping("/choose-equipment")
    public String choose(AdditionalEquipmentDto additionalEquipmentDto, Model model) {
        model.addAttribute("equipment", additionalEquipmentDto);
        System.out.println("test");
        System.out.println(additionalEquipmentDto);
        System.out.println("test");
        return "main-page";
    }
}

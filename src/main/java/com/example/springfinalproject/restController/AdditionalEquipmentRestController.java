package com.example.springfinalproject.restController;

import com.example.springfinalproject.dto.AdditionalEquipmentDto;
import com.example.springfinalproject.service.AdditionalEquipmentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class AdditionalEquipmentRestController {

    private static final Logger LOG = LoggerFactory.getLogger(AdditionalEquipmentRestController.class);
    private AdditionalEquipmentService additionalEquipmentService;

    @GetMapping("/additional-equipments")
    public ResponseEntity<List<AdditionalEquipmentDto>> getAdditionalEquipments() {
        LOG.info("Request to list all additional equipments has been received");
        return ResponseEntity.ok().body(additionalEquipmentService.findAllEquipment());
    }

    @PostMapping("/add-equipment")
    void createProblem(@RequestBody AdditionalEquipmentDto additionalEquipmentDto){
        LOG.info("Request to add a new additional equipment has been received");
        additionalEquipmentService.addAdditionalEquipment(additionalEquipmentDto);
    }
}

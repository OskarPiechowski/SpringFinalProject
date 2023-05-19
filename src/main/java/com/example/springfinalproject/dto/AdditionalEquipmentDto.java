package com.example.springfinalproject.dto;

import com.example.springfinalproject.common.InterfaceUSB;
import jakarta.persistence.Column;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalEquipmentDto {
    private int id;

    private String projectorName;
    @Nullable
    private int amount;

    //TODO jakiś picture ???

    private boolean phone;

    @Max(value = 99, message = "Internal number must be a natural number less than 100")
    private Integer internalNumber;

    @Pattern(regexp = "\\+\\d{2} \\d{10}", message = "External number must be in the format +12 1234567890")
    private String externalNumber;

    private InterfaceUSB interfaceUSB;

    @AssertTrue(message = "Internal number and external number are required when phone is true")
    private boolean isValidPhone() {
        if (phone) {
            return internalNumber != null && externalNumber != null;
        } else {
            interfaceUSB = null; // Ignoring interfaceUSB value
            return true;
        }
    }

    @Column(name = "price_per_hour")
    private BigDecimal pricePerHour;

    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;
}

package com.example.springfinalproject.entity;


import com.example.springfinalproject.common.InterfaceUSB;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_equipment")
@Builder
@EqualsAndHashCode
public class AdditionalEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectorName;
    //    pola z @Nullable są opcjonalne
    @Nullable
    private int amount;

    //TODO jakiś picture ???

    //Zgodnie z dokumentacją dodaję telefon i jeśli sitnieje, to numer wew i zewnętrzny, które mają ograniczenia:
    // wewnętrzny to liczba naturalna mniejsza od 100
    // zewnętrzny, to String w formacie +12 123456789
    private boolean phone;

    @Max(value = 99, message = "Internal number must be a natural number less than 100")
    private Integer internalNumber;

    @Pattern(regexp = "\\+\\d{2} \\d{10}", message = "External number must be in the format +12 1234567890")
    private String externalNumber;

    //Dodałem ENUMa w pakiecie common, bo będzie wykorzystywany (lub może być) rónież w innych miejscach aplikacji,
    // które ustawiać będą wartość tego atrybutu/pola.
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

    @OneToMany(mappedBy = "additionalEquipment", fetch = FetchType.EAGER)
    private List<AdditionalEquipmentReservation> equipmentReservationList = new ArrayList<>();

//    public AdditionalEquipment(String name, int amount, BigDecimal pricePerHour, BigDecimal pricePerDay,
//                               List<AdditionalEquipmentReservation> equipmentReservationList) {
//        this.name = name;
//        this.amount = amount;
//        this.pricePerHour = pricePerHour;
//        this.pricePerDay = pricePerDay;
//        this.equipmentReservationList = equipmentReservationList;
//    }
}

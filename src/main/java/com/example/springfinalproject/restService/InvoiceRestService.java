package com.example.springfinalproject.restService;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.ConferenceRoom;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.entity.RoomReservation;
import com.example.springfinalproject.exceptions.InvoiceAlreadyExistsException;
import com.example.springfinalproject.mapper.InvoiceMapper;
import com.example.springfinalproject.repository.ConferenceRoomRepository;
import com.example.springfinalproject.repository.InvoiceRepository;
import com.example.springfinalproject.repository.RoomReservationRepository;
import com.example.springfinalproject.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvoiceRestService {

    private final RoomReservationRepository roomReservationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    private final InvoiceService invoiceService;

    public InvoiceRestService(RoomReservationRepository roomReservationRepository,
                              ConferenceRoomRepository conferenceRoomRepository,
                              InvoiceRepository invoiceRepository,
                              InvoiceMapper invoiceMapper,
                              InvoiceService invoiceService) {
        this.roomReservationRepository = roomReservationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceService = invoiceService;
    }


    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Optional<RoomReservation> reservationOptional = roomReservationRepository.findById(invoiceDto.getReservationId());
        if (reservationOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        RoomReservation reservation = reservationOptional.get();
        // Sprawdź, czy dla tej rezerwacji faktura już została wystawiona i rzuć wyjątkiem, ale lepiej by było
        // wyświetlić stronkę z tą fakturą, ale to robi controler,
        // a nie service i jak to zrobić?
        if (invoiceRepository.existsByReservationId(invoiceDto.getReservationId())) {
            throw new InvoiceAlreadyExistsException("Invoice already exists for reservation ID: " + invoiceDto.getReservationId());
        }
        ConferenceRoom room = reservation.getConferenceRoom();


        // Tworzenie faktury
        Invoice invoice = new Invoice();
        invoice.setNumber(generateInvoiceNumber());
        invoice.setName(reservation.getOrganisation().getName());
        invoice.setNip(Long.valueOf(reservation.getOrganisation().getNip()));
        invoice.setAddress(reservation.getOrganisation().getAddress());
        invoice.setPostcode(reservation.getOrganisation().getPostcode());
        invoice.setCity(reservation.getOrganisation().getCity());
        invoice.setRoom_id(room.getId());
        invoice.setValue(calculateInvoiceValue(reservation));
        invoice.setDate(LocalDateTime.now());
        invoice.setReservationId(invoiceDto.getReservationId());

        // Zapis faktury
        Invoice savedInvoice = invoiceRepository.save(invoice);

        return invoiceMapper.mapToDto(savedInvoice);
    }

    private String generateInvoiceNumber() {
        // Implementacja generowania unikalnego numeru faktury
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        String formattedInstant = String.valueOf(epochSecond);
        return "INV-" + formattedInstant;
    }

    private Double calculateInvoiceValue(RoomReservation reservation) {
        BigDecimal pricePerDay = reservation.getConferenceRoom().getPricePerDay();
        LocalDate startDate = reservation.getStartDate();
        LocalDate endDate = reservation.getEndDate();
        LocalTime startTime = reservation.getStartTime();
        LocalTime endTime = reservation.getEndTime();

        if (startDate.equals(endDate)) {
            long durationInMinutes = Duration.between(startTime, endTime).toMinutes();
            double durationInHours = (double) durationInMinutes / 60;
            BigDecimal invoiceValue = pricePerDay.multiply(BigDecimal.valueOf(durationInHours));
            return invoiceValue.doubleValue();
        } else {
            long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
            BigDecimal invoiceValue = pricePerDay.multiply(BigDecimal.valueOf(numberOfDays));
            return invoiceValue.doubleValue();
        }
    }

    public List<InvoiceDto> getAllInvoices() {
        List<InvoiceDto> invoiceDtos = invoiceMapper.mapToDtos(invoiceRepository.findAll());
        return invoiceDtos;
    }


}


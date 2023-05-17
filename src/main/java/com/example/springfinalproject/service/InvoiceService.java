package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.mapper.InvoiceMapper;
import com.example.springfinalproject.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Transactional
@Service
@AllArgsConstructor
public class InvoiceService {
private InvoiceRepository invoiceRepository;
private InvoiceMapper invoiceMapper;
        public void addInvoice(InvoiceDto dto) {
                Invoice invoice = invoiceMapper.mapToEntity(dto);
                invoiceRepository.save(invoice);

}
}

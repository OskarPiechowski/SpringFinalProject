package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.InvoiceDto;
import com.example.springfinalproject.entity.Invoice;
import com.example.springfinalproject.mapper.InvoiceMapper;
import com.example.springfinalproject.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceService {
        private InvoiceRepository invoiceRepository;
        private InvoiceMapper invoiceMapper;

        public void addInvoice(InvoiceDto request) {
                Invoice invoice = invoiceMapper.mapToEntity(request);
                invoiceRepository.save(invoice);

        }

        public List<Invoice> findAllInvoices() {
                return invoiceRepository.findAll();

/*        public List<InvoiceDto> findAllInvoices() {
                List<Invoice> invoices = invoiceRepository.findAll();
                List<InvoiceDto> invoiceDtos = new ArrayList<>();
                for(Invoice invoice : invoices){
                        invoiceDtos.add(invoiceMapper.mapToDto(invoice));
                }
                return invoiceDtos;

        }*/
        }
}

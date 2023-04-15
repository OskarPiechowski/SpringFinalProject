package com.example.springfinalproject.dto;

public class InvoiceDto {
    private long id;
    private String companyName;
    private int invoiceNumber;
    private double brutInvoiceValue;

    public InvoiceDto() {
    }

    public InvoiceDto(String companyName, int invoiceNumber, double brutInvoiceValue) {
        this.companyName = companyName;
        this.invoiceNumber = invoiceNumber;
        this.brutInvoiceValue = brutInvoiceValue;
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getBrutInvoiceValue() {
        return brutInvoiceValue;
    }
}


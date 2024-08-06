package com.campaign.project.campaignproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerVisitDTO {
    private String customer_name;
    private String phone;
    private LocalDate invoiceDate;
    public CustomerVisitDTO(String customerName, String phone, LocalDate invoiceDate) {
        this.customer_name = customerName;
        this.phone = phone;
        this.invoiceDate = invoiceDate;
    }

}

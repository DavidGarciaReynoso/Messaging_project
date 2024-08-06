package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Invoices")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long invoice_id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    private double total;
}

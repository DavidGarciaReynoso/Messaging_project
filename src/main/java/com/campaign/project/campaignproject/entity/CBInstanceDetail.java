package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cb_instance_detail")
@Data
public class CBInstanceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cbinstancedetail_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private String cbphone_number;
    private int cbmessage_id;
    private String cblog;

    // Estado de transmisión
    private String status;

    public String getCbphoneNumber() {
        return cbphone_number;
    }

    public void setCbphoneNumber(String cbphone_number) {
        this.cbphone_number = cbphone_number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

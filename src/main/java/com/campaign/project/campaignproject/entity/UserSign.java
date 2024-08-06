package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "usr_sign")
@Data
public class UserSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usrcreation_id;

    private LocalDateTime usrcreation_date;
    private String usr_update;
    private LocalDateTime usrupdate_date;
    private int customer_id;
}


package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "camp_broadcasting_instance")
@Data
public class CampBroadcastingInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cbroadcasting_id;

    private LocalDateTime c_txtdatetime;
    private int ctotal_customer;
    private int usrcreation_id;
    private int cbinstancedetail_id;
}

package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "campaign")
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaign_id;

    private String camp_name;
    private String camp_description;
    private int cttype_id;
    private boolean camp_enable;
    private int usrcreation_id;
    private int cbroadcasting_id;
}

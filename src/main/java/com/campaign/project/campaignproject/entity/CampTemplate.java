package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "camp_template")
@Data
public class CampTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int camptemplate_id;

    private int cttype_id;
    private String ct_message;
    private int campaign_id;

    }



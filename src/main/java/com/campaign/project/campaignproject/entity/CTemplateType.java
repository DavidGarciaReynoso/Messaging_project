package com.campaign.project.campaignproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ctemplate_type")
@Data
public class CTemplateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cttype_id;

    private String cttype;
}

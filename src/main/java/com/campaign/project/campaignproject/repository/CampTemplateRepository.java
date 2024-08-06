package com.campaign.project.campaignproject.repository;

import com.campaign.project.campaignproject.entity.CampTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CampTemplateRepository extends JpaRepository<CampTemplate, Integer> {

    @Query("SELECT ct_message FROM CampTemplate WHERE campaign_id = ?1")
    String findMessageByCampaignId(int campaignId);
}
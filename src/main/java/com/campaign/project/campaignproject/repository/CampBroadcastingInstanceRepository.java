package com.campaign.project.campaignproject.repository;

import com.campaign.project.campaignproject.entity.CampBroadcastingInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampBroadcastingInstanceRepository extends JpaRepository<CampBroadcastingInstance, Integer> {
}

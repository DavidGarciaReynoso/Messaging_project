package com.campaign.project.campaignproject.repository;

import com.campaign.project.campaignproject.entity.CBInstanceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CBInstanceDetailRepository extends JpaRepository<CBInstanceDetail, Integer> {
}

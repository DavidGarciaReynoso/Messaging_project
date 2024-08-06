package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/daily-visit")
    public void processDailyVisitCampaign(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        campaignService.processDailyVisitCampaign(localDate);
    }
}

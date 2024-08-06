package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.entity.CampTemplate;
import com.campaign.project.campaignproject.service.CampTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CampTemplateController {
    @Autowired
    private CampTemplateService camp_templateService;

    @GetMapping()
    public List<CampTemplate> getAll(){
        return camp_templateService.getCamp_Templates();
    }
    @GetMapping("/{camp_templateId}")
    public Optional<CampTemplate> getById(@PathVariable("camp_templateId") int camp_templateId){
        return camp_templateService.getCamp_Template(camp_templateId);
    }
    @PostMapping
    public void saveUpdate(@RequestBody CampTemplate camp_template){
        camp_templateService.saveOrUpdate(camp_template);
    }
    @DeleteMapping("/{camp_templateId}")
    public void delete(@PathVariable("camp_templateId") int camp_templateId){
        camp_templateService.delete(camp_templateId);
    }
}

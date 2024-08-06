package com.campaign.project.campaignproject.service;

import com.campaign.project.campaignproject.dto.CustomerVisitDTO;
import com.campaign.project.campaignproject.entity.CampTemplate;
import com.campaign.project.campaignproject.repository.CampTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CampTemplateService {

    @Autowired
    CampTemplateRepository camp_templateRepository;

    public List<CampTemplate> getCamp_Templates() {
        return camp_templateRepository.findAll();
    }

    public Optional<CampTemplate> getCamp_Template(int id) {
        return camp_templateRepository.findById(id);
    }

    public void saveOrUpdate(CampTemplate camp_template) {
        camp_templateRepository.save(camp_template);
    }

    public void delete(int id) {
        camp_templateRepository.deleteById(id);
    }
}

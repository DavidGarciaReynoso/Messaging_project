package com.campaign.project.campaignproject.service;

import com.campaign.project.campaignproject.dto.CustomerVisitDTO;
import com.campaign.project.campaignproject.entity.Campaign;
import com.campaign.project.campaignproject.repository.CampaignRepository;
import com.campaign.project.campaignproject.repository.CampTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    MessageService messageService;

    @Autowired
    CampTemplateRepository campTemplateRepository;

    public List<Campaign> getCampaigns() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaign(int id) {
        return campaignRepository.findById(id);
    }

    public void saveOrUpdate(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    public void delete(int id) {
        campaignRepository.deleteById(id);
    }

    public void processDailyVisitCampaign(LocalDate date) {
        List<CustomerVisitDTO> customers = customerService.getCustomersByVisitDate(date);

        // Obtener el mensaje de la plantilla basado en el campaignId
        String messageTemplate = campTemplateRepository.findMessageByCampaignId(1); // Reemplaza 1 con el ID de la campaña correspondiente

        for (CustomerVisitDTO customer : customers) {
            // Reemplazar el marcador de posición con el nombre del cliente
            String message = "Hola " + customer.getCustomer_name() + ", "+ messageTemplate.replace("{customer_name}", customer.getCustomer_name());
            messageService.sendTwilioMessage(customer.getPhone(), message);
        }
    }
}

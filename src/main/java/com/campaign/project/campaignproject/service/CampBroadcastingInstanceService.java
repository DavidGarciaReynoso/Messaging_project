package com.campaign.project.campaignproject.service;

import com.campaign.project.campaignproject.entity.CampBroadcastingInstance;
import com.campaign.project.campaignproject.entity.CBInstanceDetail;
import com.campaign.project.campaignproject.repository.CampBroadcastingInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampBroadcastingInstanceService {

    private final CampBroadcastingInstanceRepository repository;
    private final MessageService messageService;

    @Autowired
    public CampBroadcastingInstanceService(CampBroadcastingInstanceRepository repository, MessageService messageService) {
        this.repository = repository;
        this.messageService = messageService;
    }

    public List<CampBroadcastingInstance> findAll() {
        return repository.findAll();
    }

    public Optional<CampBroadcastingInstance> findById(int id) {
        return repository.findById(id);
    }

    public CampBroadcastingInstance save(CampBroadcastingInstance instance) {
        return repository.save(instance);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void startBroadcasting(int instanceId, List<CBInstanceDetail> customerDetails, String messageTemplate) {
        for (CBInstanceDetail detail : customerDetails) {
            String personalizedMessage = messageTemplate.replace("{name}", detail.getCustomer().getCustomer_name());
            messageService.sendTwilioMessage(detail.getCbphoneNumber(), personalizedMessage);
            detail.setStatus("Sent");  // Assuming you want to set status to 'Sent'
            // Update detail status in the database if necessary
        }
    }
}


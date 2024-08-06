package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.entity.CampBroadcastingInstance;
import com.campaign.project.campaignproject.entity.CBInstanceDetail;
import com.campaign.project.campaignproject.service.CampBroadcastingInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campBroadcastingInstance")
public class CampBroadcastingInstanceController {

    private final CampBroadcastingInstanceService service;

    @Autowired
    public CampBroadcastingInstanceController(CampBroadcastingInstanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<CampBroadcastingInstance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampBroadcastingInstance> getById(@PathVariable int id) {
        Optional<CampBroadcastingInstance> instance = service.findById(id);
        return instance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CampBroadcastingInstance create(@RequestBody CampBroadcastingInstance instance) {
        return service.save(instance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampBroadcastingInstance> update(@PathVariable int id, @RequestBody CampBroadcastingInstance instanceDetails) {
        Optional<CampBroadcastingInstance> existingInstance = service.findById(id);

        if (existingInstance.isPresent()) {
            CampBroadcastingInstance instance = existingInstance.get();
            instance.setC_txtdatetime(instanceDetails.getC_txtdatetime());
            instance.setCtotal_customer(instanceDetails.getCtotal_customer());
            instance.setUsrcreation_id(instanceDetails.getUsrcreation_id());
            instance.setCbinstancedetail_id(instanceDetails.getCbinstancedetail_id());
            return ResponseEntity.ok(service.save(instance));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/broadcast")
    public ResponseEntity<String> startBroadcasting(@RequestParam int cbroadcastingId, @RequestBody List<CBInstanceDetail> customerDetails, @RequestParam String messageBody) {
        try {
            service.startBroadcasting(cbroadcastingId, customerDetails, messageBody);
            return ResponseEntity.ok("Broadcast started successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}

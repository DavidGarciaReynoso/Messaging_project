package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.service.MessageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SMSController {

    private final MessageService messageService;

    @PostMapping("/send")
    public String sendSMS(@RequestBody SMSRequest smsRequest) {
        try {
            messageService.sendTwilioMessage(smsRequest.getToNumbers().toString(), smsRequest.getMessageBody());
            return "Messages sent successfully!";
        } catch (Exception e) {
            return "Failed to send messages: " + e.getMessage();
        }
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "SMS Service is running";
    }

    @Data
    public static class SMSRequest {
        private List<String> toNumbers;
        private String messageBody;
    }
}

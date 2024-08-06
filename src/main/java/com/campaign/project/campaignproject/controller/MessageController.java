package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/sendTwilioMessage")
    public String sendTwilioMessage(@RequestParam String toNumber, @RequestParam String messageBody) {
        messageService.sendTwilioMessage(toNumber, messageBody);
        return "Message sent to RabbitMQ: " + messageBody;
    }
}

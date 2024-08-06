package com.campaign.project.campaignproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final RabbitMQProducer rabbitMQProducer;

    @Autowired
    public MessageService(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    public void sendTwilioMessage(String toNumber, String messageBody) {
        // Enviar el mensaje a RabbitMQ en lugar de Twilio directamente
        rabbitMQProducer.sendMessage(toNumber + ":" + messageBody);
        System.out.println("Message sent to RabbitMQ: " + toNumber + ":" + messageBody);
    }
}

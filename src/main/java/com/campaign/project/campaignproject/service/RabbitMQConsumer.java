package com.campaign.project.campaignproject.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN;

    @Value("${twilio.from-number}")
    private String FROM_NUMBER;

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        // Inicializar Twilio dentro del método en lugar del constructor
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Procesar el mensaje recibido de RabbitMQ y enviarlo a Twilio
        try {
            String[] parts = message.split(":");
            if (parts.length < 2) {
                System.err.println("Invalid message format: " + message);
                return; // Salir del método si el formato del mensaje no es válido
            }
            String toNumber = parts[0];
            String messageBody = parts[1];

            Message twilioMessage = Message.creator(
                            new PhoneNumber(toNumber),
                            new PhoneNumber(FROM_NUMBER),
                            messageBody)
                    .create();
            System.out.println("Sent message w/ sid: " + twilioMessage.getSid());
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}
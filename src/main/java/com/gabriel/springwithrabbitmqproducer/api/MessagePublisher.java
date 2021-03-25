package com.gabriel.springwithrabbitmqproducer.api;

import com.gabriel.springwithrabbitmqproducer.config.MqConfig;
import com.gabriel.springwithrabbitmqproducer.dto.CustumMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/msg")
    private String publishMenssage(@RequestBody CustumMessage message){
        message.setMessage(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);

        return "messagem publicada";
    }
}

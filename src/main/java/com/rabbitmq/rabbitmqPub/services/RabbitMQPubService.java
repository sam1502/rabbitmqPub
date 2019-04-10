package com.rabbitmq.rabbitmqPub.services;

import com.rabbitmq.rabbitmqPub.config.RabbitMQProperties;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
public class RabbitMQPubService {

    RabbitTemplate rabbitTemplate;

    RabbitMQProperties rabbitMQProperties;


    @Autowired
    public RabbitMQPubService(RabbitTemplate rabbitTemplate,
                              RabbitMQProperties rabbitMQProperties) {
        this.rabbitMQProperties = rabbitMQProperties;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void postToQueue(String info) {

        try {
            rabbitTemplate.convertAndSend(rabbitMQProperties.getRoutingKey(), rabbitMQProperties.getExchangeName(), info);
        } catch (Exception e) {
            log.error("Error posting to Queue", e);
        }
    }
}

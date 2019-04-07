package com.rabbitmq.rabbitmqPub.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("queue")
public class RabbitMQProperties {

    private String name;
    private String exchangeName;
    private String routingKey;
}

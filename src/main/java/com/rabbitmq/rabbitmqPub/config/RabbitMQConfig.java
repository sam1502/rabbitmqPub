package com.rabbitmq.rabbitmqPub.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class RabbitMQConfig {

    RabbitMQProperties rabbitMQProperties;

    @Autowired
    public RabbitMQConfig(RabbitMQProperties rabbitMQProperties) {
        this.rabbitMQProperties = rabbitMQProperties;
    }

    @Bean
    Queue queue() {
        return new Queue(rabbitMQProperties.getName(), false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(rabbitMQProperties.getExchangeName(), false, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getRoutingKey());
    }

}

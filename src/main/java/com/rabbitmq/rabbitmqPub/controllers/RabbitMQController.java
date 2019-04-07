package com.rabbitmq.rabbitmqPub.controllers;


import com.rabbitmq.rabbitmqPub.services.RabbitMQPubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("queue")
public class RabbitMQController {

    RabbitMQPubService rabbitMQPubService;

    @Autowired
    public RabbitMQController(RabbitMQPubService rabbitMQPubService) {
        this.rabbitMQPubService = rabbitMQPubService;
    }

    @PostMapping("post/{message}")
    public ResponseEntity<String> publisher(@PathVariable("message") String message) {
        log.info(message);
        rabbitMQPubService.postToQueue(message);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}

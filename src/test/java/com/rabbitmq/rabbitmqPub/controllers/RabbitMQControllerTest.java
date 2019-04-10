package com.rabbitmq.rabbitmqPub.controllers;

import com.rabbitmq.rabbitmqPub.services.RabbitMQPubService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RabbitMQControllerTest {

    @Spy
    @InjectMocks
    RabbitMQController rabbitMQController;

    MockMvc mockMvc;

    @Spy
    RabbitMQPubService rabbitMQPubService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rabbitMQController).build();
    }


    @Nested
    @DisplayName("Given queue Endpoint")
    public class GivenQueueEndPoint {

        @Nested
        @DisplayName("When post to endpoint()")
        public class WhenPostToEndpoint {

           @Test
           @DisplayName("Then return ok status")
           public void thenReturnOkStatus() throws Exception{


               doNothing().when(rabbitMQPubService).postToQueue(anyString());

               mockMvc.perform(post("/queue/post/{message}", "hello")
               .contentType(MediaType.APPLICATION_JSON_VALUE))
                       .andExpect(status().isOk())
                       .andReturn();


           }

        }


    }

}
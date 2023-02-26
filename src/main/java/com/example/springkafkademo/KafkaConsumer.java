package com.example.springkafkademo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC_NAME = "topic5";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMessage) {
        try {
            MyMessage myMessage = objectMapper.readValue(jsonMessage, MyMessage.class);
            log.warn("my name = {}, my message = {}", myMessage.getName(), myMessage.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

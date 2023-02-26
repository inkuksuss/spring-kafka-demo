package com.example.springkafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final String TOPIC_NAME = "topic5";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, MyMessage> jsonKafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendWithCallback(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("send = " + message + " offset = " + result.getRecordMetadata().offset());
            } else {
                System.out.println("fail = " + message + " due to = " + ex.getMessage());
            }
        });
    }

    public void sendJson(MyMessage message) {
        jsonKafkaTemplate.send(TOPIC_NAME, message);
    }
}

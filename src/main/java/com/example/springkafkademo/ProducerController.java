package com.example.springkafkademo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducerService service;

    @RequestMapping("/publish")
    public String publish(String message) {
        service.send(message);
        return "published a message : " + message;
    }

    @RequestMapping("/publish2")
    public String publishWithCallback(String message) {
        service.sendWithCallback(message);
        return "published a message : " + message;
    }

    @RequestMapping("/publish3")
    public String publishJson(@ModelAttribute MyMessage message) {
        service.sendJson(message);
        return "published a message : " + message.getName() + " " + message.getMessage();
    }
}

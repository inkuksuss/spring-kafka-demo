package com.example.springkafkademo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MyMessage {

    private String name;
    private String message;

    public MyMessage() {
    }

    public MyMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }
}

package com.example.rsocketdemo.rsocketdemo.model;

import lombok.Data;

import java.time.Instant;

@Data
public class MessageResponse {
    private String msg;

    MessageResponse(){}

    MessageResponse withGreeting(String msg){
        this.msg = msg;
        return this;
    }

    public MessageResponse(String msg) {
        this.withGreeting("Hello " + msg + " @ " + Instant.now());
    }
}

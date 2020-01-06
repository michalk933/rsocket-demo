package com.example.rsocketdemo.rsocketdemo.controller;


import com.example.rsocketdemo.rsocketdemo.model.MessageRequest;
import com.example.rsocketdemo.rsocketdemo.model.MessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Controller
class GreetingRSocketController {

    @MessageMapping("message")
    MessageResponse greet(MessageRequest greetingReqiest) {
        System.out.println("CHECK == " + greetingReqiest.getMsg());
        return new MessageResponse(greetingReqiest.getMsg());
    }

    @MessageMapping("message-stream")
    Flux<MessageResponse> greetStream(MessageRequest greetingReqiest) {
        System.out.println("CHECK == " + greetingReqiest.getMsg());
        return Flux
                .fromStream(Stream.generate(() -> new MessageResponse(greetingReqiest.getMsg())))
                .delayElements(Duration.ofSeconds(1));
    }


}
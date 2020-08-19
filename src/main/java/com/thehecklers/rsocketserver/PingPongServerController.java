package com.thehecklers.rsocketserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class PingPongServerController {
    @MessageMapping("pingpong")
    Mono<Pong> pingpong(Ping ping) {
        System.out.println("   >>> Incoming ping: " + ping.getMessage());
        return Mono.just(new Pong("Returning ->" + ping.getMessage() + "<-"));
    }
}

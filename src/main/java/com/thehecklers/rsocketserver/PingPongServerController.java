package com.thehecklers.rsocketserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class PingPongServerController {
    @MessageMapping("pingpong")
    Mono<Pong> pingpong(Ping ping) {
        System.out.println("   >>> Incoming ping: " + ping.getMessage());
        return Mono.just(new Pong("Returning ->" + ping.getMessage() + "<-"));
    }

    @MessageMapping("pingpongflux")
    Flux<Pong> pingpongflux(Flux<Ping> pingFlux) {
        return pingFlux.map(ping -> new Pong("Returning ->" + ping.getMessage() + "<-"));
    }

    @MessageMapping("onetomany")
    Flux<Pong> pingpongflux(Ping ping) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> new Pong("Returning ->" + ping.getMessage() + "<-"));
    }
}

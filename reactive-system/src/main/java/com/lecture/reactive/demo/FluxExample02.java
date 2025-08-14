package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FluxExample02 {

    public static void main(String[] args) {
        Flux.just(Mono.justOrEmpty(1)
                .concatWith(Mono.just(10))
                .subscribe(value -> log.info("value = {}", value)));
    }
}

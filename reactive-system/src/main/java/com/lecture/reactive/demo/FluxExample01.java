package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxExample01 {

    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{3, 6, 7, 9})
                .filter(value -> value > 7)
                .map(value -> value * 2)
                .subscribe(value -> log.info("value = {}", value));
    }
}

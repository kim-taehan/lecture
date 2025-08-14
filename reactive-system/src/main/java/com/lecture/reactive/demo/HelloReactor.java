package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class HelloReactor {

    public static void main(String[] args) {
        Mono.just("hello reactor")
                .subscribe(message -> System.out.println("message = " + message));

        Flux.just("hi", "hello")
                .map(String::toUpperCase)
                .subscribe(message -> log.info("message = {}, {}", message, Thread.currentThread().getName()));
    }
}

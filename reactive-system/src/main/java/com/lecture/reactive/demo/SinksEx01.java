package com.lecture.reactive.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.stream.IntStream;

public class SinksEx01 {

    public static void main(String[] args) {
        Sinks.Many<String> many = Sinks.many().multicast().onBackpressureBuffer();

        Flux<String> flux = many.asFlux();
        Flux<String> manyflux = many.asFlux();
        flux.subscribe(value -> System.out.println("value1 = " + value));
        many.emitNext("Test1", Sinks.EmitFailureHandler.FAIL_FAST);
        many.emitNext("Test2", Sinks.EmitFailureHandler.FAIL_FAST);
        flux.subscribe(value -> System.out.println("value2 = " + value));




    }
}

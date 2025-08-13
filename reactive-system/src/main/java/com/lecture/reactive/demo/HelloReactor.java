package com.lecture.reactive.demo;

import reactor.core.publisher.Mono;

public class HelloReactor {

    public static void main(String[] args) {
        Mono.just("hello reactor")
                .subscribe(message -> System.out.println("message = " + message));
    }
}

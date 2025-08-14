package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoExample {

    public static void main(String[] args) {
        Mono.empty()
                .subscribe(
                        data -> log.info("# emitted data : {}", data),
                        Throwable::printStackTrace,
                        () -> log.info("on complete")
                );
    }
}

package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public record ParallelTest() {

    @Test
    void parallel() {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15})
                .parallel()
                .subscribe(value -> log.info("{}", value));
    }

    @Test
    void parallelRunOn() {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 3, 5, 7, 9, 11, 13, 15})
                .parallel(4)
                .runOn(Schedulers.parallel())
                .subscribe(value -> log.info("{}", value));

    }
}

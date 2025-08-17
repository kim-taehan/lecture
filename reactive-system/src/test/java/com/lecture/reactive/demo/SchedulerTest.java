package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
public record SchedulerTest() {

    @Test
    void noScheduler() {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .filter(data -> data > 3)
                .map(data -> data + 10)
                .subscribe(value -> log.info("{}", value));
    }

    @Test
    void publisherOn() {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .doOnNext(value -> log.info("doOnNext = {}", value))
                .publishOn(Schedulers.parallel())
                .filter(data -> data > 3)
                .map(data -> data + 10)
                .subscribe(value -> log.info("subscribe = {}", value));
    }

    @Test
    void subscribeOn() {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .doOnNext(value -> log.info("doOnNext = {}", value))
                .subscribeOn(Schedulers.boundedElastic())
                .filter(data -> data > 3)
                .map(data -> data + 10)
                .subscribe(value -> log.info("subscribe = {}", value));
    }

    @Test
    void combination1() {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .doOnNext(value -> log.info("doOnNext1 = {}", value))
                .subscribeOn(Schedulers.boundedElastic())
                .filter(data -> data > 3)
                .doOnNext(value -> log.info("doOnNext2 = {}", value))
                .publishOn(Schedulers.parallel())
                .doOnNext(value -> log.info("doOnNext3 = {}", value))
                .map(data -> data + 10)
                .subscribe(value -> log.info("subscribe = {}", value));
    }

    @Test
    void combination2() {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .doOnNext(value -> log.info("doOnNext1 = {}", value))
                .publishOn(Schedulers.parallel())
                .filter(data -> data > 3)
                .doOnNext(value -> log.info("doOnNext2 = {}", value))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(value -> log.info("doOnNext3 = {}", value))
                .map(data -> data + 10)
                .subscribe(value -> log.info("subscribe = {}", value));
    }
}


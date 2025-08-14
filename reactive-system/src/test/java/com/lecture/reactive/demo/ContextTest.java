package com.lecture.reactive.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.logging.Logger;

@Slf4j
public record ContextTest() {

    @Test
    void contextBasic() throws InterruptedException {
        String key = "message";
        Mono<String> mono = Mono.deferContextual(ctx ->
                        Mono.just("hello" + " " + ctx.get(key)).doOnNext(log::info)
                )
                .subscribeOn(Schedulers.boundedElastic())
                .publishOn(Schedulers.parallel())
                .transformDeferredContextual((mono2, ctx) -> mono2.map(data -> data + " " + ctx.get(key)))
                .contextWrite(context -> context.put(key, "Reactor2"));

        mono.subscribe(log::info);

        Thread.sleep(100L);

    }

    @Test
    void contextFeature() throws InterruptedException {
        String key = "id";

        Mono<String> mono = Mono.deferContextual(ctx -> Mono.just("ID : " + ctx.get(key)));

        mono.contextWrite(context -> context.put(key, "itVillage"))
                .subscribe(data -> log.info("subscriber 1={}", data));


        mono.contextWrite(context -> context.put(key, "itWorld"))
                .subscribe(data -> log.info("subscriber 2={}", data));

        Thread.sleep(100L);
    }
}

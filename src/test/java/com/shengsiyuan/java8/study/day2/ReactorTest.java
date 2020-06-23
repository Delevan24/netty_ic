package com.shengsiyuan.java8.study.day2;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ReactorTest {
    private Flux<Integer> generateFluxFrom1To6() {
        return Flux.just(1, 2, 3, 4, 5, 6);
    }

    private Mono<Integer> generateMonoWithError() {
        return Mono.error(new Exception("some error"));
    }

    @Test
    public void testViaStepVerifier() {
        /*StepVerifier.create(generateFluxFrom1To6())
                .expectNext(1, 2, 3, 4, 5, 6)
                .expectComplete()
                .verify();
        StepVerifier.create(generateMonoWithError())
                .expectErrorMessage("some error")
                .verify();


        StepVerifier.create(Flux.range(1, 6)
                .map(i -> i * 2))
                .expectNext(2, 4, 6, 8, 10, 12)
                .expectComplete()
                .verify();
*/
        StepVerifier.create(
                Flux.just("flux", "mono")
                        .flatMap(s -> Flux.fromArray(s.split("\\s*"))
                                .delayElements(Duration.ofMillis(100)))
                        .doOnRequest(System.out::print))
                .expectNextCount(8).verifyComplete();

        Flux.just("flux", "mono")
                .flatMap(s -> Flux.fromArray(s.split("\\s*"))
                        .delayElements(Duration.ofMillis(100)).doOnNext(System.out::print));


    }

    private Flux<String> getZipDescFlux() {
        String desc = "Zip two sources together, that is to say wait for all the sources to emit one element and combine these elements once into a Tuple2.";
        return Flux.fromArray(desc.split("\\s+"));  // 1
    }

    @Test
    public void testSimpleOperators() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);  // 2
        Flux.zip(
                getZipDescFlux(),
                Flux.interval(Duration.ofMillis(200)))  // 3
                .subscribe(t -> System.out.println(t.getT1()), null, countDownLatch::countDown);    // 4
        countDownLatch.await(10, TimeUnit.SECONDS);     // 5
    }


    private String getStringSync() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }

    @Test
    public void testSyncToAsync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.fromCallable(() -> getStringSync())    // 1
                .subscribeOn(Schedulers.elastic())  // 2
                .subscribe(System.out::println, null, countDownLatch::countDown);
        System.out.println("主线程完成");
        countDownLatch.await(10, TimeUnit.SECONDS);
    }


    @Test
    public void testErrorHandling() {
        Flux.range(1, 6)
                .map(i -> 10/(i-3)) // 1
                .map(i -> i*i)
                .subscribe(System.out::println, System.err::println);
    }


}

package com.xiaoju.reactor;

import com.esotericsoftware.minlog.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReactorTest {
    public static void main(String[] args) {
        String str = "hello";
        Optional optional = Optional.of("world");
        Mono.just("hello, world").subscribe(System.out::println);
        Mono.justOrEmpty(str).subscribe(System.out::println);
        Mono.justOrEmpty(optional).subscribe(System.out::println);

        Flux.just("hello", "world").subscribe(System.out::println);
        Flux.just("hello").subscribe(System.out::println);

        String[] array = new String[]{"hello", "reactor", "flux"};
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");

        Flux.fromArray(array).subscribe(System.out::println);
        Flux.fromIterable(iterable).subscribe(System.out::println);
        Flux.fromStream(Arrays.stream(array)).subscribe(System.out::println);

        System.out.println("________________");
        Flux.range(3, 5).subscribe(System.out::println);

        System.out.println("________________");
        Flux.empty().subscribe(System.out::println, System.out::println, () -> System.out.println("结束"));
        Flux.never().subscribe(System.out::println, System.out::println, () -> System.out.println("结束"));

        System.out.println("________________");

        Flux.just(1, 2, 3, 4, 5, 6).subscribe(
                System.out::println,
                System.err::println,
                () -> System.out.println("Completed!"));

        System.out.println("________________");



    }
}

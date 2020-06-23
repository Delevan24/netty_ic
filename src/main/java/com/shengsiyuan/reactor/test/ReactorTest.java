package com.shengsiyuan.reactor.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReactorTest {
    public static void main(String[] args) {

        Flux.just(1, 2, 3, 4, 5, 6);
        Mono.just(1);

        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Flux.fromArray(integers);

        List<Integer> integers1 = Arrays.asList(integers);
        Flux.fromIterable(integers1);

        Stream<Integer> stream = integers1.stream();
        Flux.fromStream(stream);

        // 只有完成信号的空数据流
        Flux.just();
        Flux.empty();
        Mono.empty();
        Mono.justOrEmpty(Optional.empty());

        // 只有错误信号的数据流
        Flux.error(new Exception("error"));
        Mono.error(new Exception("error"));


        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
        System.out.println();
        Mono.just(1).subscribe(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 6).subscribe(
                System.out::println,
                System.err::println,
                ()-> System.out.println("Completed!!"));

        //Mono.error(new Exception("exception~~~~~")).subscribe(
        //        System.out::println,
        //        System.err::println,
        //        ()-> System.out.println("Completed!!"));


    }
}

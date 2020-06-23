package com.shengsiyuan.java8.stream;

import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        //ArrayList<String> strings = Lists.newArrayList("hello", "world", "test");
        //
        //strings.stream().map(String::toUpperCase).forEach(System.out::println);
        //
        //ArrayList<Integer> ints = Lists.newArrayList(1, 2, 3, 4);
        //ints.stream().map(i -> i * i).forEach(System.out::println);
        //System.out.println("---------");
        //Stream<List<Integer>> steam = Stream.of(Lists.newArrayList(1), Lists.newArrayList(4), Lists.newArrayList(2, 3));
        //steam.flatMap(Collection::stream).map(i -> i * i).forEach(System.out::println);

        //System.out.println("----------------");

        //Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        //stream.findAny().ifPresent(System.out::println);

        int sum = Stream.iterate(1, item -> item + 2)
                .limit(20)
                .filter(i -> i > 20)
                .mapToInt(i -> i * 2)
                .skip(2)
                .limit(2)
                .sum();
        System.out.println(sum);


    }
}

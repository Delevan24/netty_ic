package com.shengsiyuan.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        IntStream.of(5, 6, 7).forEach(System.out::print);
        IntStream.rangeClosed(2, 5).forEach(System.out::print);
        System.out.println("-----------------------");
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 45, 5);
        integers.stream().map(i -> i * 2).forEach(System.out::print);
        System.out.println("");
        System.out.println("-----------------------");
        IntStream.rangeClosed(2, 5).map(i -> i * 2).forEach(System.out::print);
        System.out.println("");
        System.out.println("-----------------------");
        Stream<String> aaa = Stream.of("aaa", "fff", "ddd");
        //String[] strings = aaa.toArray(a -> new String[a]);
        //Arrays.asList(strings).forEach(System.out::println);
        ////
        //List<String> list = aaa.collect(() -> new ArrayList<>(),
        //        (theList, item) -> theList.add(item),
        //        (l1, l2) -> l1.addAll(l2));
        //List<String> list = aaa.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        //List<String> list = aaa.collect(Collectors.toList());
        //List<String> list = aaa.collect(Collectors.toCollection(LinkedList::new));
        //list.forEach(System.out::println);
        String s = aaa.collect(Collectors.joining()).toString();
        System.out.println(s);



        //List<String> list = aaa.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        //list.forEach(System.out::println);
    }
}

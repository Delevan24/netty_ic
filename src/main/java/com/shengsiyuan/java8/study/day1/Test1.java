package com.shengsiyuan.java8.study.day1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
        System.out.println("---------------");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("---------------");
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("---------------");
        integers.forEach(integer -> System.out.println(integer));
        System.out.println("---------------");

        System.out.println("---------------");


    }
}

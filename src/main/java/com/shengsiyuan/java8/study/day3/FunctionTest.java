package com.shengsiyuan.java8.study.day3;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(1, value -> value * 2));
        System.out.println(functionTest.compute(1, value -> value + 2));
        System.out.println(functionTest.compute(1, value -> value * value));

        System.out.println(functionTest.compute1(1, value -> value + "assas"));

    }

    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String compute1(int a, Function<Integer, String> function) {
        return function.apply(a);
    }
}

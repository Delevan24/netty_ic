package com.shengsiyuan.java8.study.day3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {
    public static void main(String[] args) {

        FunctionTest2 functionTest2 = new FunctionTest2();
        System.out.println(functionTest2.compose(2, value -> value * 3, value -> value * value));
        System.out.println(functionTest2.compose1(2, value -> value * 3, value -> value * value));

        System.out.println(functionTest2.compute2(1, 2, (value1, value2) -> value1 + value2));
        System.out.println(functionTest2.compute2(1, 2, (value1, value2) -> value1 - value2));
        System.out.println(functionTest2.compute2(1, 2, (value1, value2) -> value1 * value2));
        System.out.println(functionTest2.compute2(1, 2, (value1, value2) -> value1 / value2));

        System.out.println(functionTest2.compute3(3, 2, (value1, value2) -> value1 + value2, value-> value * value));


    }

    //compose before 先执行结果当参数传入
    public int compose(int a, Function<Integer, Integer> function, Function<Integer, Integer> function1) {
        return function.compose(function1).apply(a);
    }

    // andThen after 限执行自己当参数
    public int compose1(int a, Function<Integer, Integer> function, Function<Integer, Integer> function1) {
        return function.andThen(function1).apply(a);
    }

    public int compute2(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}

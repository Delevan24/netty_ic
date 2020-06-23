package com.shengsiyuan.java8.study.supplier;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryTest {
    public static void main(String[] args) {

        System.out.println(BinaryTest.compute(1, 2, Integer::sum));
        System.out.println(BinaryTest.getmin(1, 2, (a, b) -> a - b));
    }

    public static int compute(int a, int b, BinaryOperator<Integer> operator) {
        return operator.apply(a, b);
    }

    public static int getmin(int a, int b, Comparator<Integer> operator) {
        return BinaryOperator.minBy(operator).apply(a, b);
    }
}

package com.shengsiyuan.java8.study.collector;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;

public class CollectorTest1 {
    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("nihao", "haeee", "adafd", "4323");

        //strings.stream().sorted().forEach(System.out::println);
        strings.stream().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::println);






    }
}

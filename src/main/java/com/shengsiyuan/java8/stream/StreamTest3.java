package com.shengsiyuan.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {
    public static void main(String[] args) {

        ArrayList<String> strings = Lists.newArrayList("ss", "adlkj", "你好");
        ArrayList<String> strings1 = Lists.newArrayList("张三", "lis", "王五", "houzi");
        //strings.stream().flatMap(item -> strings1.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);
        List<String> collect = strings.stream().flatMap(item -> strings1.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        System.out.println(collect.stream().count());
        System.out.println(collect.stream().collect(Collectors.counting() ));


    }
}

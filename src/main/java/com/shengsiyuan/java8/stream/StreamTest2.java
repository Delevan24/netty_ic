package com.shengsiyuan.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest2 {
    public static void main(String[] args) {
        //ArrayList<Object> objects = Lists.newArrayList();
        //
        //for (int i = 0; i < 5000000; i++) {
        //    objects.add(UUID.randomUUID().toString());
        //}
        //
        //System.out.println("开始排序");
        //long l = System.nanoTime();
        //long count = objects.parallelStream().sorted().count();
        //long l1 = System.nanoTime();
        //System.out.println("耗时: " + TimeUnit.NANOSECONDS.toMillis(l1 - l));
        ArrayList<String> strings = Lists.newArrayList("hello world", "hello you", "no yes");
        strings.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


    }
}

package com.shengsiyuan.java8.study.day3;

import com.google.common.collect.Lists;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //ThreeInterface t1 = () -> {
        //};
        //System.out.println(t1.getClass().getInterfaces()[0]);
        //ThreeInterface1 t2 = () -> {
        //};
        //System.out.println(t2.getClass().getInterfaces()[0]);
        //
        //new Thread(()->{
        //    System.out.println("helloworld");
        //}).start();
        //

        List<String> list = Lists.newArrayList("hello", "world", "my test");
        //list.forEach(str -> {
        //    System.out.println(str.toUpperCase());
        //})
        //List<Object> list1 = Lists.newArrayList();
        //list.forEach(item->list1.add(item.toUpperCase()));
        //list1.forEach(System.out::println);

        //list.stream().map(String::toUpperCase).forEach(System.out::println);

        //Function<String, String> function = String::toUpperCase;
        //System.out.println(function.getClass().getInterfaces()[0]);






    }
}

@FunctionalInterface
interface ThreeInterface {
    void three();
}


@FunctionalInterface
interface ThreeInterface1 {
    void three1();
}



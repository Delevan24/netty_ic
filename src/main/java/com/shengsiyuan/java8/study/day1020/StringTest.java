package com.shengsiyuan.java8.study.day1020;

public class StringTest {
    public static void main(String[] args) {
        String aa = new StringBuilder("ali").append("baba").toString();
        System.out.println(aa);
        System.out.println(aa.intern());
        System.out.println(aa==aa.intern());



        String bb = new StringBuilder("ja").append("va").toString();
        System.out.println(bb);
        System.out.println(bb.intern());
        System.out.println(bb==bb.intern());
    }
}

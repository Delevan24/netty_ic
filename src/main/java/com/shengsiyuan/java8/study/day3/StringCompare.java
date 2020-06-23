package com.shengsiyuan.java8.study.day3;

import com.google.common.collect.Lists;

import java.util.List;

public class StringCompare {
    public static void main(String[] args) {
        List<String> es = Lists.newArrayList("zhangsan", "lisi", "wangwu");
        //Collections.sort(es, new Comparator<String>() {
        //            @Override
        //            public int compare(String o1, String o2) {
        //                return o2.compareTo(o1);
        //            }
        //        });
        //
        //        System.out.println(es);
        //es.sort(String::compareTo);
        //System.out.println(es);

    }
}

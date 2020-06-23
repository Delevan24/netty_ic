package com.shengsiyuan.java8.study.predicate;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2.conditionFilter(list, integer -> integer % 2 == 0);
        System.out.println("-------------------");
        PredicateTest2.conditionFilter(list, integer -> integer % 2 != 0);
        System.out.println("-------------------");
        PredicateTest2.conditionFilter(list, integer -> integer > 5);
        System.out.println("-------------------");
        PredicateTest2.conditionFilter(list, integer -> integer < 5);
        System.out.println("-------------------");
        PredicateTest2.conditionFilter(list, integer -> true);
        System.out.println("-------------------");
        PredicateTest2.conditionFilter(list, integer -> false);
        System.out.println("-------------------");
        PredicateTest2.condition2(list, integer -> integer > 5, in -> in % 2 == 0);
        System.out.println("-------------------");
        System.out.println(PredicateTest2.isEqual("test").test("test"));
        System.out.println("-------------------");


    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(in -> {
            if (predicate.test(in)) {
                System.out.println(in);
            }
        });
    }

    public static void condition2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        list.forEach(in -> {
            if (predicate.and(predicate2).test(in)) {
                System.out.println(in);
            }
        });
    }

    public static Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }

}

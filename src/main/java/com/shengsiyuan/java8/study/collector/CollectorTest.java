package com.shengsiyuan.java8.study.collector;

import com.google.common.collect.Lists;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorTest {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan", 80, 21);
        Student lisi = new Student("lisi", 90, 20);
        Student wangwu = new Student("wangwu", 60, 22);
        Student songliu = new Student("songliu", 80, 23);
        ArrayList<Student> students = Lists.newArrayList(zhangsan, lisi, wangwu, songliu);


        students.stream().min(Comparator.comparingInt(Student::getScore)).ifPresent(System.out::println);
        //students.stream().mapToInt(Student::getScore).min().ifPresent(System.out::println);
        students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students.stream().collect(Collectors.averagingDouble(Student::getScore)));
        System.out.println((Integer) students.stream().mapToInt(Student::getScore).sum());

        IntSummaryStatistics collect = students.stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println(collect);

        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",")));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",","aaa","bbb")));

        Map<Integer, Map<String, List<Student>>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(collect1);

        Map<Boolean, List<Student>> collect2 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 70));
        Map<Boolean, Map<Boolean, List<Student>>> collect3 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 70, Collectors.partitioningBy(s -> s.getScore() > 85)));

        System.out.println(collect2);
        System.out.println(collect3);

        Map<Boolean, Long> collect4 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 70,Collectors.counting()));

        System.out.println(collect4);

        Map<String, Student> collect5 = students.stream().collect(Collectors.toMap(Student::getName, Function.identity(), BinaryOperator.minBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(collect5);

    }
}

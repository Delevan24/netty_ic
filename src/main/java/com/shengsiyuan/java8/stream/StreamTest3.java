package com.shengsiyuan.java8.stream;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {
	public static void main(String[] args) {
		
		ArrayList<String> strings = Lists.newArrayList("ss", "adlkj", "bdlkj", "cdlkj", "ddlkj", "你好");
		ArrayList<String> strings1 = Lists.newArrayList("张三", "lis", "王五", "houzi");
		//strings.stream().flatMap(item -> strings1.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);
		// List<String> collect = strings.stream().flatMap(item -> strings1.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
		// System.out.println(collect.stream().count());
		// System.out.println(collect.stream().cect(Collectors.counting()));
		
		// Collections.sort(strings, Comparator.comparing(String::length)
		// 		.thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));
		//
		Collections.sort(strings,Comparator.comparing(String::length).reversed()
				.thenComparing(Comparator.comparing(String::length,Comparator.reverseOrder())));
		
		System.out.println(strings);
		
	}
}

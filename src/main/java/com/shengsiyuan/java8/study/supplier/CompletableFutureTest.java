package com.shengsiyuan.java8.study.supplier;

import com.google.common.collect.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "my first test";
        });

        System.out.println(future.get());

        HashMultiset<Integer> multiset = HashMultiset.create();
        multiset.add(2, 3);//添加指定个数的重复元素
        multiset.count(2); //获取元素在集合中的个数
        multiset.remove(2, 2); //移除指定的个数元素
        multiset.setCount(5, 2); //和add相同
        multiset.setCount(5, 2, 3); //修改集合中元素的个数,2个改为3个
        //常见功能,统计每个字符出现的此数
        String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        HashMultiset<String> multisetStr = HashMultiset.create();
        multisetStr.addAll(Arrays.asList(strWorld.split("\\|")));
        multisetStr.elementSet().forEach(x -> System.out.println(x + " :" + multisetStr.count(x)));


        BiMap<Integer, String> hashBiMap = HashBiMap.create();
        hashBiMap.put(1, "用户1");
        hashBiMap.put(2, "用户2");
        hashBiMap.put(3, "用户3");
        //键值转换
        BiMap<String, Integer> inverseBiMap = hashBiMap.inverse();
        inverseBiMap.entrySet().forEach(x ->
                System.out.println("key:" + x.getKey() + ", value:" + x.getValue()));
        //因为值唯一(需要翻转时候key唯一),所以添加时如果value存在抛异常,可使用forcePut强制替换键
        // hashBiMap.put(4,"用户3");  IllegalArgumentException
        hashBiMap.forcePut(4, "用户3"); //强制替换用户3的键为4
        //根据kv进行消费返回结果
        String compute = hashBiMap.compute(4, (x, y) -> x + y);
        System.out.println(compute); // 4用户3


        Table<String, String, Integer> hashBasedTable = HashBasedTable.create();
        hashBasedTable.put("一班", "数学", 97);
        hashBasedTable.put("二班", "英语", 85);
        hashBasedTable.put("二班", "语文", 70);
        hashBasedTable.get("一班", "数学"); //通过两个key获取value
        hashBasedTable.columnKeySet(); //获取列key  [数学, 英语, 语文]
        hashBasedTable.rowKeySet();//获取行key   [一班, 二班]
        //获取所有行的set
        hashBasedTable.cellSet().forEach(x ->
                System.out.println("rowKey:" + x.getRowKey() +
                        ", columnKey:" + x.getColumnKey() + ", value:" + x.getValue()));
        hashBasedTable.row("二班"); //根据rowKey获取所有对应的columnKey和value的 map
        hashBasedTable.column("数学"); //根据columnKey获取所有对应的rowKey和value 的 map
        hashBasedTable.rowMap(); //获取rowKey对应的 列-value map
        hashBasedTable.remove("一班", "数学"); //移除元素
        hashBasedTable.columnMap(); //获取columnKey对应的 rowKey-value map

        Optional<String> hello = Optional.of("hello");
        hello.ifPresent(System.out::println);
        hello.ifPresent(op-> System.out.println(op));
        System.out.println(hello.orElseGet(()->"hellssss"));


        Student student = new Student();
        student.setName("xiaohobg");
        student.setAge(10);

        CompletableFutureTest completableFutureTest = new CompletableFutureTest();


        System.out.println(completableFutureTest.getSupplier(()->"sss"));
    }

    public String getSupplier(Supplier<String> supplier){
        return supplier.get() + "test";
    }
}

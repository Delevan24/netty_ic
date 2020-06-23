package com.shengsiyuan.java8.study.supplier;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> {
            return "hello";
        };
        System.out.println(stringSupplier.get());

        Supplier<Student> supplier = () -> new Student("sss", 111);
        System.out.println(supplier.get().getName());

        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.get().getName());

    }
}

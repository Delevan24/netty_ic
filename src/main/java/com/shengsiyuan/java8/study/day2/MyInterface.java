package com.shengsiyuan.java8.study.day2;

@FunctionalInterface
interface MyInterface {
    void test();

    @Override
    String toString();
}

class Test {
    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.myTest(() -> {
            System.out.println("success1");
        });
        MyInterface myInterface = () -> {
            System.out.println("u");
        };
    }
}

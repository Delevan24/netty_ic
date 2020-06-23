package com.shengsiyuan.java8.study.predicate;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 10);
        Person person2 = new Person("lisi", 20);
        Person person3 = new Person("wangwu", 30);

        ArrayList<Person> people = Lists.newArrayList(person1, person2, person3);

        //List<Person> zhangsan = getPersonsByUsername("zhangsan", people);
        List<Person> personByAge = getPersonByAge(20, people);
        personByAge.forEach(person -> System.out.println(person.getUsername()));
        System.out.println("+++++++++++++");

        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        List<Person> person = getPerson(10, people, biFunction);
        person.forEach(p -> System.out.println(p.getUsername()));
    }

    public static List<Person> getPersonsByUsername(String username, List<Person> personList) {
        return personList.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(int age, List<Person> people) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        return biFunction.apply(age, people);
    }

    public static List<Person> getPerson(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }


}

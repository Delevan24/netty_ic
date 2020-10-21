package com.shengsiyuan.thrift;

import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsernam(String username) throws DataException, TException {

        System.out.println("Gor Cilent Param: " + username);
        Person person = new Person();
        person.setAge(20);
        person.setMarried(false);
        person.setUsername(username);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Gor Cilent Param: " + person.getUsername());
        System.out.println("Gor Cilent Param: " + person.getAge());
        System.out.println("Gor Cilent Param: " + person.isMarried());

    }
}

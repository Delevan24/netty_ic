package com.shengsiyuan.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;

public class ThriftClient {
    public static void main(String[] args) {
        TFastFramedTransport localhost = new TFastFramedTransport(new TSocket("localhost", 8899), 600);
        TCompactProtocol tCompactProtocol = new TCompactProtocol(localhost);
        PersonService.Client client = new PersonService.Client(tCompactProtocol);
        try {
            localhost.open();

            Person zhangsna = client.getPersonByUsernam("zhangsna");
            System.out.println(zhangsna.getAge());
            System.out.println(zhangsna.getUsername());
            System.out.println(zhangsna.isMarried());

            System.out.println("----------------------");

            Person person = new Person();
            person.setAge(20);
            person.setMarried(false);
            person.setUsername("list");

            client.savePerson(person);


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            localhost.close();
        }

    }
}

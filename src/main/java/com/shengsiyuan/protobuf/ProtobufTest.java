package com.shengsiyuan.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufTest {


    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAdress("beijing").build();
        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student1);

    }
}

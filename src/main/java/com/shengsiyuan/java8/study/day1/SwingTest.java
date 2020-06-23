package com.shengsiyuan.java8.study.day1;

import javax.swing.*;

public class SwingTest {
    public static void main(String[] args) {
        JFrame my_jframe = new JFrame("My Jframe");
        JButton my_jButton = new JButton("My JButton");
        my_jButton.addActionListener(e -> System.out.println("button pressed!"));
        my_jframe.add(my_jButton);
        my_jframe.pack();
        my_jframe.setVisible(true);
        my_jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

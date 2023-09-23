package com.cur10sdev.abstractDemo;

public class Son extends Parent {

    Son(int age, int value) {
        super(age, value);
    }
    @Override
    void career(String name) {
        System.out.println("I am going to be a " + name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love " + name + " and she is " + age);
    }
}

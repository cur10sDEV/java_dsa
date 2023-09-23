package com.cur10sdev.abstractDemo;

abstract public class Parent {
    int age;
    final int VALUE;

    public Parent(int age, int value) {
        this.age = age;
        VALUE = value;
    }

    static void greet() {
        System.out.println("Hello");
    }

    abstract void career(String name);

    abstract void partner(String name, int age);
}

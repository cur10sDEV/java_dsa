package com.cur10sdev.interfaces.exntendDemo;

public interface A {

    interface Nested {
        boolean isOdd(int num);
    }
    void fun();

    static void greet() {
        System.out.println("I am a static method from the interface A");
    }
}

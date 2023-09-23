package com.cur10sdev.interfaces.exntendDemo;

public class Main implements A, B {
    @Override
    public void fun() {
        System.out.println("Fun from A");
    }
    @Override
    public void buzz() {
        System.out.println("Buzz from B");
    }

    public static void main(String[] args) {
        A.greet();
    }
}

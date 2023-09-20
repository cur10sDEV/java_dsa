package com.cur10sdev.staticExample;

public class Main {
    public static void main(String[] args) {
        Main.fun();
    }

    static void fun() {
        // greeting(); // error

        Main obj = new Main();
        obj.greeting(); // will run
    }

    void greeting() {
        System.out.println("Hello World!");
    }
}

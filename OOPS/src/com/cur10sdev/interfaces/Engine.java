package com.cur10sdev.interfaces;

public interface Engine {
    int PRICE = 0;
    default void start() {
        System.out.println("Vroom");
    };
    void stop();
    void acc();
}